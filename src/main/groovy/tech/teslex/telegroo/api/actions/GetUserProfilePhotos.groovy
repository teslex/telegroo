package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait GetUserProfilePhotos {

	def getUserProfilePhotos(userId = lastUpdate.message.from.id, Map params = [:]) {
		api.go(new Some('getUserProfilePhotos', [user_id: userId] + params))
	}
}