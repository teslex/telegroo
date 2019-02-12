package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomeAudio

trait SendAudio {

	def sendAudio(File audio, Map params = [:]) {
		sendAudio(audio, lastUpdate.updateData.message.chat.id, params)
	}

	def sendAudio(String audio, Map params = [:]) {
		sendAudio(audio, lastUpdate.updateData.message.chat.id, params)
	}

	def sendAudioId(String audioId, Map params = [:]) {
		sendAudioId(audioId, lastUpdate.updateData.message.chat.id, params)
	}

	def sendAudio(File audio, chatId, Map params = [:]) {
		api.go(new SomeAudio(audio, [chat_id: chatId] + params))
	}

	def sendAudio(String audio, chatId, Map params = [:]) {
		api.go(new Some('sendAudio', [chat_id: chatId, audio: audio] + params))
	}

	def sendAudioId(String audioId, chatId, Map params = [:]) {
		api.go(new Some('sendAudio', [chat_id: chatId, audio: [file_id: audioId]] + params))
	}
}
