package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.SomeFile
import tech.teslex.telegroo.api.some.SomeMediaGroup

trait SendMediaGroup {

	def sendMediaGroup(List<SomeFile> media, Map params = [:]) {
		sendMediaGroup(media, lastUpdate.updateData.message.chat.id, params)
	}

	def sendMediaGroup(List<SomeFile> media, chatId, Map params = [:]) {
		api.go(new SomeMediaGroup(media, [chat_id: chatId] + params))
	}

	def sendMediaGroupMap(List<Map> media, chatId, Map params = [:]) {
		api.goWithMediaGroup('sendMediaGroup', media, [chat_id: chatId] + params)
	}
}
