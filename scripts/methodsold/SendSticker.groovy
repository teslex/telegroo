package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomeSticker

@CompileStatic
trait SendSticker extends AbstractContext {

	def sendSticker(File sticker, Map params = [:]) {
		sendSticker(sticker, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def sendSticker(String sticker, Map params = [:]) {
		sendSticker(sticker, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	def sendStickerId(String stickerId, Map params = [:]) {
		sendStickerId(stickerId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
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
