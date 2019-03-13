package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait SetWebhook extends AbstractContext {

	def setWebhook(url, Map params = [:]) {
		api.go(new Some('setWebhook', [url: url.toString()] + params))
	}
}
