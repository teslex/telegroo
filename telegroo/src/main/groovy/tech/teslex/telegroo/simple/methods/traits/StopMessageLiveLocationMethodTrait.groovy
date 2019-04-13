package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.StopMessageLiveLocationMethod
import tech.teslex.telegroo.telegram.methods.objects.StopMessageLiveLocationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait StopMessageLiveLocationMethodTrait implements StopMessageLiveLocationMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> stopMessageLiveLocation(@NamedDelegate StopMessageLiveLocationMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> stopMessageLiveLocation(Map data) {
		stopMessageLiveLocation(data as StopMessageLiveLocationMethodObject)
	}

	@Override
	TelegramResult<Object> stopMessageLiveLocation(@DelegatesTo(StopMessageLiveLocationMethodObject) Closure closure) {
		StopMessageLiveLocationMethodObject builder = new StopMessageLiveLocationMethodObject()
		closure.delegate = builder
		closure.call()
		stopMessageLiveLocation(builder)
	}
}
