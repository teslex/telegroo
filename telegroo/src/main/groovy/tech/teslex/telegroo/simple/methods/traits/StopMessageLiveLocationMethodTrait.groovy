package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.StopMessageLiveLocationMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.StopMessageLiveLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait StopMessageLiveLocationMethodTrait implements StopMessageLiveLocationMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> stopMessageLiveLocation(@NamedDelegate StopMessageLiveLocationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> stopMessageLiveLocation(Map data) {
		stopMessageLiveLocation(data as StopMessageLiveLocationMethodObject)
	}

	@Override
	TelegramResult<Message> stopMessageLiveLocation(@DelegatesTo(StopMessageLiveLocationMethodObject) Closure closure) {
		def builder = StopMessageLiveLocationMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		stopMessageLiveLocation(builder)
	}
}
