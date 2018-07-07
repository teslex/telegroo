package tech.teslex.telegroo.api.actions

trait SendVoice {

	def sendVoice(File voice, Map params = [:]) {
		sendVoice(voice, lastUpdate.message.chat.id, params)
	}

	def sendVoice(String voice, Map params = [:]) {
		sendVoice(voice, lastUpdate.message.chat.id, params)
	}

	def sendVoiceId(String voiceId, Map params = [:]) {
		sendVoiceId(voiceId, lastUpdate.message.chat.id, params)
	}

	def sendVoice(File voice, chatId, Map params = [:]) {
		api.goWithFile('sendVoice', voice, 'voice', [chat_id: chatId] + params)
	}

	def sendVoice(String voice, chatId, Map params = [:]) {
		api.go('sendVoice', [chat_id: chatId, voice: voice] + params)
	}

	def sendVoiceId(String voiceId, chatId, Map params = [:]) {
		api.go('sendVoice', [chat_id: chatId, voice: [file_id: voiceId]] + params)
	}
}