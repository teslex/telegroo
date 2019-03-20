package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendStickerMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendStickerMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendStickerMethodTrait implements SendStickerMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendSticker(@NamedDelegate SendStickerMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendSticker(Map data) {
		sendSticker(data as SendStickerMethodObject)
	}

	@Override
	TelegramResult<Message> sendSticker(@DelegatesTo(SendStickerMethodObject) Closure closure) {
		def builder = SendStickerMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendSticker(builder)
	}
}
