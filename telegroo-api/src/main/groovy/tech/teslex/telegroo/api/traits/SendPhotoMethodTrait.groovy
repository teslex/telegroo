package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendPhotoMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendPhotoMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendPhotoMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendPhoto(@NamedDelegate SendPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendPhoto(Map data) {
		sendPhoto(data as SendPhotoMethodObject)
	}

	TelegramResult<Message> sendPhoto(@DelegatesTo(SendPhotoMethodObjectBuilder) Closure closure) {
		def builder = new SendPhotoMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendPhoto(builder.build())
	}
}