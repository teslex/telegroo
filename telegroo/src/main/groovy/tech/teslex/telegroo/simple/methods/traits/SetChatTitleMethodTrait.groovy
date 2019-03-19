package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SetChatTitleMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatTitleMethodObject

@CompileStatic
trait SetChatTitleMethodTrait implements SetChatTitleMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatTitle(@NamedDelegate SetChatTitleMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setChatTitle(Map data) {
		setChatTitle(data as SetChatTitleMethodObject)
	}

	@Override
	TelegramResult<Object> setChatTitle(@DelegatesTo(SetChatTitleMethodObject) Closure closure) {
		def builder = SetChatTitleMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatTitle(builder)
	}
}
