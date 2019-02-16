package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.SomeFile
import tech.teslex.telegroo.api.some.SomeMediaGroup

trait SendMediaGroup {

	def sendMediaGroup(List<SomeFile> media, Map params = [:]) {
		sendMediaGroup(media, lastUpdate.updateData[lastUpdate.updateType].chat.id, params)
	}

	def sendMediaGroup(List<SomeFile> media, chatId, Map params = [:]) {
		api.go(new SomeMediaGroup(media, [chat_id: chatId] + params))
	}

	def sendMediaGroupMap(List<Map> media, chatId, Map params = [:]) {
		api.goWithMediaGroup('sendMediaGroup', media, [chat_id: chatId] + params)
	}
}
