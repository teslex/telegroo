package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some
import tech.teslex.telegroo.api.req.SomeVideoNote

trait SendVideoNote {

	def sendVideoNote(File videoNote, Map params = [:]) {
		sendVideoNote(videoNote, lastUpdate.message.chat.id, params)
	}

	def sendVideoNote(String videoNote, Map params = [:]) {
		sendVideoNote(videoNote, lastUpdate.message.chat.id, params)
	}

	def sendVideoNoteId(String videoNoteId, Map params = [:]) {
		sendVideoNoteId(videoNoteId, lastUpdate.message.chat.id, params)
	}

	def sendVideoNote(File videoNote, chatId, Map params = [:]) {
		api.go(new SomeVideoNote(videoNote, [chat_id: chatId] + params))
	}

	def sendVideoNote(String videoNote, chatId, Map params = [:]) {
		api.go(new Some('sendVideoNote', [chat_id: chatId, video_note: videoNote] + params))
	}

	def sendVideoNoteId(String videoNoteId, chatId, Map params = [:]) {
		api.go(new Some('sendVideoNote', [chat_id: chatId, video_note: [file_id: videoNoteId]] + params))
	}
}