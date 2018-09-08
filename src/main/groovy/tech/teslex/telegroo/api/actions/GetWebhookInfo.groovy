package tech.teslex.telegroo.api.actions

trait GetWebhookInfo {

	def getWebhookInfo(Map params = [:]) {
		api.go('getWebhookInfo', params)
	}
}
