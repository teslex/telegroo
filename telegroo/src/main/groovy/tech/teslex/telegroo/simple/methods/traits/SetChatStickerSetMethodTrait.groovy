package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SetChatStickerSetMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatStickerSetMethodObject

@CompileStatic
trait SetChatStickerSetMethodTrait implements SetChatStickerSetMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatStickerSet(@NamedDelegate SetChatStickerSetMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setChatStickerSet(Map data) {
		setChatStickerSet(data as SetChatStickerSetMethodObject)
	}

	@Override
	TelegramResult<Object> setChatStickerSet(@DelegatesTo(SetChatStickerSetMethodObject) Closure closure) {
		def builder = SetChatStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatStickerSet(builder)
	}
}
