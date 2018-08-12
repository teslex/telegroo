package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.SomeFile
import tech.teslex.telegroo.api.req.SomeMediaGroup

trait SendMediaGroup {

	def sendMediaGroup(List<? extends SomeFile> media, Map params = [:]) {
		sendMediaGroup(media, lastUpdate.message.chat.id, params)
	}

	def sendMediaGroup(List<? extends SomeFile> media, chatId, Map params = [:]) {
		api.go(new SomeMediaGroup(media, [chat_id: chatId] + params))
	}

	def sendMediaGroupMap(List<Map<String, Object>> media, chatId, Map params = [:]) {
		api.goWithMediaGroup('sendMediaGroup', media, [chat_id: chatId] + params)
	}
}
