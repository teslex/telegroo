package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SetChatDescriptionMethod
import tech.teslex.telegroo.telegram.methods.objects.SetChatDescriptionMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SetChatDescriptionMethodTrait implements SetChatDescriptionMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatDescription(@NamedDelegate SetChatDescriptionMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setChatDescription(Map data) {
		setChatDescription(data as SetChatDescriptionMethodObject)
	}

	@Override
	TelegramResult<Object> setChatDescription(@DelegatesTo(SetChatDescriptionMethodObject) Closure closure) {
		SetChatDescriptionMethodObject builder = new SetChatDescriptionMethodObject()
		closure.delegate = builder
		closure.call()
		setChatDescription(builder)
	}
}
