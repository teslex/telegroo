package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendPhotoMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendPhotoMethodObject
import tech.teslex.telegroo.telegram.types.InputFile
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendPhotoMethodTrait implements SendPhotoMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	TelegramResult<Message> sendPhoto(InputFile photo) {
		sendPhoto([photo: photo] as SendPhotoMethodObject)
	}

	@Override
	@NamedVariant
	TelegramResult<Message> sendPhoto(@NamedDelegate SendPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendPhoto(Map data) {
		sendPhoto(data as SendPhotoMethodObject)
	}

	@Override
	TelegramResult<Message> sendPhoto(@DelegatesTo(SendPhotoMethodObject) Closure closure) {
		def builder = SendPhotoMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendPhoto(builder)
	}
}