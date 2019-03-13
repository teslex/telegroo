package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomeAudio
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendAudio extends AbstractContext {

	Message sendAudio(File audio, Map params = [:]) {
		sendAudio(audio, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendAudio(String audio, Map params = [:]) {
		sendAudio(audio, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendAudioId(String audioId, Map params = [:]) {
		sendAudioId(audioId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendAudio(File audio, chatId, Map params = [:]) {
		def result = api.go(new SomeAudio(audio, [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendAudio(String audio, chatId, Map params = [:]) {
		def result = api.go(new Some('sendAudio', [chat_id: chatId, audio: audio] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendAudioId(String audioId, chatId, Map params = [:]) {
		def result = api.go(new Some('sendAudio', [chat_id: chatId, audio: [file_id: audioId]] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}
