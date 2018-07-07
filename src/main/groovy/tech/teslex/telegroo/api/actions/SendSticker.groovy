package tech.teslex.telegroo.api.actions

trait SendSticker {

	def sendSticker(File sticker, Map params = [:]) {
		sendSticker(sticker, lastUpdate.message.chat.id, params)
	}

	def sendSticker(String sticker, Map params = [:]) {
		sendSticker(sticker, lastUpdate.message.chat.id, params)
	}

	def sendStickerId(String stickerId, Map params = [:]) {
		sendStickerId(stickerId, lastUpdate.message.chat.id, params)
	}

	def sendSticker(File sticker, chatId, Map params = [:]) {
		api.goWithFile('sendSticker', sticker, 'sticker', [chat_id: chatId] + params)
	}

	def sendSticker(String sticker, chatId, Map params = [:]) {
		api.go('sendSticker', [chat_id: chatId, sticker: sticker] + params)
	}

	def sendStickerId(String stickerId, chatId, Map params = [:]) {
		api.go('sendSticker', [chat_id: chatId, sticker: [file_id: stickerId]] + params)
	}
}
