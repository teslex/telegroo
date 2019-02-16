package tech.teslex.telegroo.api.methods

trait DeleteWebhook {

	def deleteWebhook(Map params = [:]) {
		api.go('deleteWebhook', params)
	}
}
