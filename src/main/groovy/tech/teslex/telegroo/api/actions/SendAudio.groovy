package tech.teslex.telegroo.api.actions

trait SendAudio {

	def sendAudio(File audio, Map params = [:]) {
		sendAudio(audio, lastUpdate.message.chat.id, params)
	}

	def sendAudio(String audio, Map params = [:]) {
		sendAudio(audio, lastUpdate.message.chat.id, params)
	}

	def sendAudioId(String audioId, Map params = [:]) {
		sendAudioId(audioId, lastUpdate.message.chat.id, params)
	}

	def sendAudio(File audio, chatId, Map params = [:]) {
		api.goWithFile('sendAudio', audio, 'audio', [chat_id: chatId] + params)
	}

	def sendAudio(String audio, chatId, Map params = [:]) {
		api.go('sendAudio', [chat_id: chatId, audio: audio] + params)
	}

	def sendAudioId(String audioId, chatId, Map params = [:]) {
		api.go('sendAudio', [chat_id: chatId, audio: [file_id: audioId]] + params)
	}
}
