package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomeVideo
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendVideo extends AbstractContext {

	Message sendVideo(File video, Map params = [:]) {
		sendVideo(video, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVideo(String video, Map params = [:]) {
		sendVideo(video, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVideoId(String videoId, Map params = [:]) {
		sendVideoId(videoId, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendVideo(File video, chatId, Map params = [:]) {
		def result = api.go(new SomeVideo(video, [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendVideo(String video, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVideo', [chat_id: chatId, video: video] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendVideoId(String videoId, chatId, Map params = [:]) {
		def result = api.go(new Some('sendVideo', [chat_id: chatId, video: [file_id: videoId]] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}