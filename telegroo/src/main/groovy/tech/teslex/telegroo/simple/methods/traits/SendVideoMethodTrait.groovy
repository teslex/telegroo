package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendVideoMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendVideoMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVideoMethodTrait implements SendVideoMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendVideo(@NamedDelegate SendVideoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendVideo(Map data) {
		sendVideo(data as SendVideoMethodObject)
	}

	@Override
	TelegramResult<Message> sendVideo(@DelegatesTo(SendVideoMethodObject) Closure closure) {
		def builder = SendVideoMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendVideo(builder)
	}
}