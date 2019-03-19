package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatTitleMethodObject

@CompileStatic
trait SetChatTitleMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> setChatTitle(@NamedDelegate SetChatTitleMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setChatTitle(Map data) {
		setChatTitle(data as SetChatTitleMethodObject)
	}

	TelegramResult<Object> setChatTitle(@DelegatesTo(SetChatTitleMethodObject) Closure closure) {
		def builder = SetChatTitleMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatTitle(builder)
	}
}
