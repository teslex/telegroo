package tech.teslex.telegroo.api.actions

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
		api.goWithFile('sendVideo', video, 'video', [chat_id: chatId] + params)
	}

	def sendVideo(String video, chatId, Map params = [:]) {
		api.go('sendVideo', [chat_id: chatId, video: video] + params)
	}

	def sendVideoId(String videoId, chatId, Map params = [:]) {
		api.go('sendVideo', [chat_id: chatId, video: [file_id: videoId]] + params)
	}
}