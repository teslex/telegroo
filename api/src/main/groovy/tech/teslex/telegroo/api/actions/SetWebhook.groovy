package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.some.Some

trait SetWebhook {

	def setWebhook(String url, Map params = [:]) {
		api.go(new Some('setWebhook', [url: url] + params))
	}
}
