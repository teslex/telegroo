package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some
import tech.teslex.telegroo.api.req.SomeVideo

trait SendVideo {

	def sendVideo(File video, Map params = [:]) {
		sendVideo(video, lastUpdate.message.chat.id, params)
	}

	def sendVideo(String video, Map params = [:]) {
		sendVideo(video, lastUpdate.message.chat.id, params)
	}

	def sendVideoId(String videoId, Map params = [:]) {
		sendVideoId(videoId, lastUpdate.message.chat.id, params)
	}

	def sendVideo(File video, chatId, Map params = [:]) {
		api.go(new SomeVideo(video, [chat_id: chatId] + params))
	}

	def sendVideo(String video, chatId, Map params = [:]) {
		api.go(new Some('sendVideo', [chat_id: chatId, video: video] + params))
	}

	def sendVideoId(String videoId, chatId, Map params = [:]) {
		api.go(new Some('sendVideo', [chat_id: chatId, video: [file_id: videoId]] + params))
	}
}