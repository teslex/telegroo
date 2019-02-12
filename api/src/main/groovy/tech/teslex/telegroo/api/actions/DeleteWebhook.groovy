package tech.teslex.telegroo.api.actions

trait DeleteWebhook {

	def deleteWebhook(Map params = [:]) {
		api.go('deleteWebhook', params)
	}
}
