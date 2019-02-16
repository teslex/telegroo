package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomeVoice

trait SendVoice {

	def sendVoice(File voice, Map params = [:]) {
		sendVoice(voice, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendVoice(String voice, Map params = [:]) {
		sendVoice(voice, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendVoiceId(String voiceId, Map params = [:]) {
		sendVoiceId(voiceId, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendVoice(File voice, chatId, Map params = [:]) {
		api.go(new SomeVoice(voice, [chat_id: chatId] + params))
	}

	def sendVoice(String voice, chatId, Map params = [:]) {
		api.go(new Some('sendVoice', [chat_id: chatId, voice: voice] + params))
	}

	def sendVoiceId(String voiceId, chatId, Map params = [:]) {
		api.go(new Some('sendVoice', [chat_id: chatId, voice: [file_id: voiceId]] + params))
	}
}
