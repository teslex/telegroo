package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait DeleteChatStickerSet {

	def setChatStickerSet(chatId = lastUpdate.updateData[lastUpdate.updateType].chat.id, Map params = [:]) {
		api.go(new Some('setChatStickerSet', [chat_id: chatId] + params))
	}
}
