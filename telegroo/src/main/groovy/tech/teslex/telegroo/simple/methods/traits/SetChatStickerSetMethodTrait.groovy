package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SetChatStickerSetMethod
import tech.teslex.telegroo.telegram.methods.objects.SetChatStickerSetMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SetChatStickerSetMethodTrait implements SetChatStickerSetMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatStickerSet(@NamedDelegate SetChatStickerSetMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setChatStickerSet(Map data) {
		setChatStickerSet(data as SetChatStickerSetMethodObject)
	}

	@Override
	TelegramResult<Object> setChatStickerSet(@DelegatesTo(SetChatStickerSetMethodObject) Closure closure) {
		SetChatStickerSetMethodObject builder = new SetChatStickerSetMethodObject()
		closure.delegate = builder
		closure.call()
		setChatStickerSet(builder)
	}
}
