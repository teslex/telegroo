package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatStickerSetMethodObject

@CompileStatic
trait SetChatStickerSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> setChatStickerSet(@NamedDelegate SetChatStickerSetMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setChatStickerSet(Map data) {
		setChatStickerSet(data as SetChatStickerSetMethodObject)
	}

	TelegramResult<Object> setChatStickerSet(@DelegatesTo(SetChatStickerSetMethodObject) Closure closure) {
		def builder = SetChatStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatStickerSet(builder)
	}
}
