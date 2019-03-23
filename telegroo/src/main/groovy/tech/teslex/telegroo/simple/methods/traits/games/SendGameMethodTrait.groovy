package tech.teslex.telegroo.simple.methods.traits.games

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.games.SendGameMethod
import tech.teslex.telegroo.telegram.methods.objects.games.SendGameMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendGameMethodTrait implements SendGameMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	TelegramResult<Object> sendGame(Map data) {
		sendGame(data as SendGameMethodObject)
	}

	@Override
	@NamedVariant
	TelegramResult<Object> sendGame(@NamedDelegate SendGameMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> sendGame(@DelegatesTo(SendGameMethodObject) Closure closure) {
		def builder = SendGameMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendGame(builder)
	}
}
