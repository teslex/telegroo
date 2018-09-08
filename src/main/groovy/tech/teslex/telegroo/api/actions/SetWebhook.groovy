package tech.teslex.telegroo.api.actions

trait SetWebhook {

	def setWebhook(String url, Map params = [:]) {
		api.go('setWebhook', [url: url] + params)
	}
}
