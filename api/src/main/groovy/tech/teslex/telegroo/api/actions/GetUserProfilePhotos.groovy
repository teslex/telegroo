package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait GetUserProfilePhotos {

	def getUserProfilePhotos(userId = lastUpdate.updateData.message.from.id, Map params = [:]) {
		api.go(new Some('getUserProfilePhotos', [user_id: userId] + params))
	}
}