package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetUserProfilePhotos {

	def getUserProfilePhotos(userId = lastUpdate.updateData[lastUpdate.updateType].from.id, Map params = [:]) {
		api.go(new Some('getUserProfilePhotos', [user_id: userId] + params))
	}
}