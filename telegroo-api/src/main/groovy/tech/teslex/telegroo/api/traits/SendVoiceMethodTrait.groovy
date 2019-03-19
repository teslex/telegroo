package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendVoiceMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVoiceMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Message> sendVoice(@NamedDelegate SendVoiceMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendVoice(Map data) {
		sendVoice(data as SendVoiceMethodObject)
	}

	TelegramResult<Message> sendVoice(@DelegatesTo(SendVoiceMethodObject) Closure closure) {
		def builder = SendVoiceMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendVoice(builder)
	}
}