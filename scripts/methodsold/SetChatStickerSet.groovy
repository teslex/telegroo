package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait SetChatStickerSet extends AbstractContext {

	def setChatStickerSet(stickerSetName, Map params = [:]) {
		setChatStickerSet(stickerSetName, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def setChatStickerSet(stickerSetName, chatId, Map params = [:]) {
		api.go(new Some('setChatStickerSet', [chat_id: chatId, sticker_set_name: stickerSetName] + params))
	}
}
