package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatDescriptionMethodObject

@CompileStatic
trait SetChatDescriptionMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> setChatDescription(@NamedDelegate SetChatDescriptionMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setChatDescription(Map data) {
		setChatDescription(data as SetChatDescriptionMethodObject)
	}

	TelegramResult<Object> setChatDescription(@DelegatesTo(SetChatDescriptionMethodObject) Closure closure) {
		def builder = SetChatDescriptionMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatDescription(builder)
	}
}
