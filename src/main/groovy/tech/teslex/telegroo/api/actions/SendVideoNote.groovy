package tech.teslex.telegroo.api.actions

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
		api.goWithFile('sendVideoNote', video_note, 'video_note', [chat_id: chatId] + params)
	}

	def sendVideoNote(String videoNote, chatId, Map params = [:]) {
		api.go('sendVideoNote', [chat_id: chatId, video_note: video_note] + params)
	}

	def sendVideoNoteId(String videoNoteId, chatId, Map params = [:]) {
		api.go('sendVideoNote', [chat_id: chatId, video_note: [file_id: video_noteId]] + params)
	}
}