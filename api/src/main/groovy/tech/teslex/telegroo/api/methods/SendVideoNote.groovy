package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomeVideoNote

trait SendVideoNote {

	def sendVideoNote(File videoNote, Map params = [:]) {
		sendVideoNote(videoNote, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendVideoNote(String videoNote, Map params = [:]) {
		sendVideoNote(videoNote, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendVideoNoteId(String videoNoteId, Map params = [:]) {
		sendVideoNoteId(videoNoteId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
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