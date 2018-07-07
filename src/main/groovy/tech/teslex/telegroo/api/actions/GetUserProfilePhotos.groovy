package tech.teslex.telegroo.api.actions

trait GetUserProfilePhotos {

	def getUserProfilePhotos(userId = lastUpdate.message.from.id, Map params = [:]) {
		api.go('getUserProfilePhotos', [user_id: userId] + params)
	}
}