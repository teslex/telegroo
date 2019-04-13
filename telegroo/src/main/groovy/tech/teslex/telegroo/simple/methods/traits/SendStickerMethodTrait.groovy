package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendStickerMethod
import tech.teslex.telegroo.telegram.methods.objects.SendStickerMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendStickerMethodTrait implements SendStickerMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> sendSticker(@NamedDelegate SendStickerMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendSticker(Map data) {
		sendSticker(data as SendStickerMethodObject)
	}

	@Override
	TelegramResult<Message> sendSticker(@DelegatesTo(SendStickerMethodObject) Closure closure) {
		SendStickerMethodObject builder = new SendStickerMethodObject()
		closure.delegate = builder
		closure.call()
		sendSticker(builder)
	}
}
