package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.UnpinChatMessageMethodObject

@CompileStatic
trait UnpinChatMessageMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> unpinChatMessage(@NamedDelegate UnpinChatMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> unpinChatMessage(Map data) {
		unpinChatMessage(data as UnpinChatMessageMethodObject)
	}

	TelegramResult<Object> unpinChatMessage(@DelegatesTo(UnpinChatMessageMethodObject) Closure closure) {
		def builder = UnpinChatMessageMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		unpinChatMessage(builder)
	}
}
