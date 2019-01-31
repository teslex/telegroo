package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some
import tech.teslex.telegroo.api.req.SomeDocument

trait SendDocument {

	def sendDocument(File document, Map params = [:]) {
		sendDocument(document, lastUpdate.message.chat.id, params)
	}

	def sendDocument(document, Map params = [:]) {
		sendDocument(document.toString(), lastUpdate.message.chat.id, params)
	}

	def sendDocumentId(documentId, Map params = [:]) {
		sendDocumentId(documentId.toString(), lastUpdate.message.chat.id, params)
	}

	def sendDocument(File document, chatId, Map params = [:]) {
		api.go(new SomeDocument(document, [chat_id: chatId] + params))
	}

	def sendDocument(document, chatId, Map params = [:]) {
		api.go(new Some('sendDocument', [chat_id: chatId, document: document.toString()] + params))
	}

	def sendDocumentId(documentId, chatId, Map params = [:]) {
		api.go(new Some('sendDocument', [chat_id: chatId, document: [file_id: documentId.toString()]] + params))
	}
}