package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomeVideoNote
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendVideoNote extends AbstractContext {

	Message sendVideoNote(File videoNote, Map params = [:]) {
		sendVideoNote(videoNote, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVideoNote(String videoNote, Map params = [:]) {
		sendVideoNote(videoNote, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVideoNoteId(String videoNoteId, Map params = [:]) {
		sendVideoNoteId(videoNoteId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVideoNote(File videoNote, chatId, Map params = [:]) {
		def result = api.go(new SomeVideoNote(videoNote, [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendVideoNote(String videoNote, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVideoNote', [chat_id: chatId, video_note: videoNote] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendVideoNoteId(String videoNoteId, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVideoNote', [chat_id: chatId, video_note: [file_id: videoNoteId]] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}