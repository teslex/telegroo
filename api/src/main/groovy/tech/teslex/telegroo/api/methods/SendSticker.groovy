package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomeSticker
trait SendSticker {

	def sendSticker(File sticker, Map params = [:]) {
		sendSticker(sticker, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendSticker(String sticker, Map params = [:]) {
		sendSticker(sticker, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendStickerId(String stickerId, Map params = [:]) {
		sendStickerId(stickerId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendSticker(File sticker, chatId, Map params = [:]) {
		api.go(new SomeSticker(sticker, [chat_id: chatId] + params))
	}

	def sendSticker(String sticker, chatId, Map params = [:]) {
		api.go(new Some('sendSticker', [chat_id: chatId, sticker: sticker] + params))
	}

	def sendStickerId(String stickerId, chatId, Map params = [:]) {
		api.go(new Some('sendSticker', [chat_id: chatId, sticker: [file_id: stickerId]] + params))
	}
}
