package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendPhotoMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendPhotoMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Message> sendPhoto(@NamedDelegate SendPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendPhoto(Map data) {
		sendPhoto(data as SendPhotoMethodObject)
	}

	TelegramResult<Message> sendPhoto(@DelegatesTo(SendPhotoMethodObject) Closure closure) {
		def builder = SendPhotoMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendPhoto(builder)
	}
}