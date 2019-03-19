package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendAudioMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendAudioMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Message> sendAudio(@NamedDelegate SendAudioMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendAudio(Map data) {
		sendAudio(data as SendAudioMethodObject)
	}

	TelegramResult<Message> sendAudio(@DelegatesTo(SendAudioMethodObject) Closure closure) {
		def builder = SendAudioMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendAudio(builder)
	}
}