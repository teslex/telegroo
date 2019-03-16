package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendChatActionMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendChatActionMethodObject

@CompileStatic
trait SendChatActionMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> sendChatAction(@NamedDelegate SendChatActionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> sendChatAction(Map data) {
		sendChatAction(data as SendChatActionMethodObject)
	}

	TelegramResult<Object> sendChatAction(@DelegatesTo(SendChatActionMethodObjectBuilder) Closure closure) {
		def builder = new SendChatActionMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendChatAction(builder.build())
	}
}
