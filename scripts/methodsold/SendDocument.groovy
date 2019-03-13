package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomeDocument
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendDocument extends AbstractContext {

	Message sendDocument(File document, Map params = [:]) {
		sendDocument(document, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendDocument(document, Map params = [:]) {
		sendDocument(document.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendDocumentId(documentId, Map params = [:]) {
		sendDocumentId(documentId.toString(), lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendDocument(File document, chatId, Map params = [:]) {
		def result = api.go(new SomeDocument(document, [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendDocument(document, chatId, Map params = [:]) {
		def result = api.go(new Some('sendDocument', [chat_id: chatId, document: document.toString()] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendDocumentId(documentId, chatId, Map params = [:]) {
		def result = api.go(new Some('sendDocument', [chat_id: chatId, document: [file_id: documentId.toString()]] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}