package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.DeleteChatStickerSetMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatStickerSetMethodObject

@CompileStatic
trait DeleteChatStickerSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> deleteChatStickerSet(@NamedDelegate DeleteChatStickerSetMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> deleteChatStickerSet(Map data) {
		deleteChatStickerSet(data as DeleteChatStickerSetMethodObject)
	}

	TelegramResult<Object> deleteChatStickerSet(@DelegatesTo(DeleteChatStickerSetMethodObjectBuilder) Closure closure) {
		def builder = new DeleteChatStickerSetMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		deleteChatStickerSet(builder.build())
	}
}