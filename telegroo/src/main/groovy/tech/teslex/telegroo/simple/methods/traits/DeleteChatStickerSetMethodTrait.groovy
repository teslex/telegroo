package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.DeleteChatStickerSetMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatStickerSetMethodObject

@CompileStatic
trait DeleteChatStickerSetMethodTrait implements DeleteChatStickerSetMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteChatStickerSet(@NamedDelegate DeleteChatStickerSetMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> deleteChatStickerSet(Map data) {
		deleteChatStickerSet(data as DeleteChatStickerSetMethodObject)
	}

	@Override
	TelegramResult<Object> deleteChatStickerSet(@DelegatesTo(DeleteChatStickerSetMethodObject) Closure closure) {
		def builder = DeleteChatStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		deleteChatStickerSet(builder)
	}
}
