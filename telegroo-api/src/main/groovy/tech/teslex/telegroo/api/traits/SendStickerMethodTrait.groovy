package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendStickerMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendStickerMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendStickerMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendSticker(@NamedDelegate SendStickerMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendSticker(Map data) {
		sendSticker(data as SendStickerMethodObject)
	}

	TelegramResult<Message> sendSticker(@DelegatesTo(SendStickerMethodObjectBuilder) Closure closure) {
		def builder = new SendStickerMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendSticker(builder.build())
	}
}