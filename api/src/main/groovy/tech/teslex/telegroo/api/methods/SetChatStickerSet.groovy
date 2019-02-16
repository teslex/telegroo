package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait SetChatStickerSet {

	def setChatStickerSet(stickerSetName, Map params = [:]) {
		setChatStickerSet(userId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def setChatStickerSet(stickerSetName, chatId, Map params = [:]) {
		api.go(new Some('setChatStickerSet', [chat_id: chatId, sticker_set_name: stickerSetName] + params))
	}
}
