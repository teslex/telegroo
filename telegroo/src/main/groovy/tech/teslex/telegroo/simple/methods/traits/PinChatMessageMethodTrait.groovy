package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.PinChatMessageMethodObject

@CompileStatic
trait PinChatMessageMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> pinChatMessage(@NamedDelegate PinChatMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> pinChatMessage(Map data) {
		pinChatMessage(data as PinChatMessageMethodObject)
	}

	TelegramResult<Object> pinChatMessage(@DelegatesTo(PinChatMessageMethodObject) Closure closure) {
		def builder = PinChatMessageMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		pinChatMessage(builder)
	}
}
