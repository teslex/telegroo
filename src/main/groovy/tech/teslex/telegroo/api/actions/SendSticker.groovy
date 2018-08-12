package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some
import tech.teslex.telegroo.api.req.SomeSticker

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
		api.go(new SomeSticker(sticker, [chat_id: chatId] + params))
	}

	def sendSticker(String sticker, chatId, Map params = [:]) {
		api.go(new Some('sendSticker', [chat_id: chatId, sticker: sticker] + params))
	}

	def sendStickerId(String stickerId, chatId, Map params = [:]) {
		api.go(new Some('sendSticker', [chat_id: chatId, sticker: [file_id: stickerId]] + params))
	}
}
