package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomeVoice
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendVoice extends AbstractContext {

	Message sendVoice(File voice, Map params = [:]) {
		sendVoice(voice, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVoice(String voice, Map params = [:]) {
		sendVoice(voice, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVoiceId(String voiceId, Map params = [:]) {
		sendVoiceId(voiceId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVoice(File voice, chatId, Map params = [:]) {
		def result = api.go(new SomeVoice(voice, [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendVoice(String voice, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVoice', [chat_id: chatId, voice: voice] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendVoiceId(String voiceId, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVoice', [chat_id: chatId, voice: [file_id: voiceId]] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}
