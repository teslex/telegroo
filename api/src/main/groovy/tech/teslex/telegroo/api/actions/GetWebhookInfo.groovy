package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait GetWebhookInfo {

	def getWebhookInfo(Map params = [:]) {
		api.go(new Some('getWebhookInfo', params))
	}
}
