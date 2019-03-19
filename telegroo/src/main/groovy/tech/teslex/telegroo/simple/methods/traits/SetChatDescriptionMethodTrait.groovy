package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SetChatDescriptionMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatDescriptionMethodObject

@CompileStatic
trait SetChatDescriptionMethodTrait implements SetChatDescriptionMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatDescription(@NamedDelegate SetChatDescriptionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setChatDescription(Map data) {
		setChatDescription(data as SetChatDescriptionMethodObject)
	}

	@Override
	TelegramResult<Object> setChatDescription(@DelegatesTo(SetChatDescriptionMethodObject) Closure closure) {
		def builder = SetChatDescriptionMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatDescription(builder)
	}
}
