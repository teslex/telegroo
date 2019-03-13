package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait GetWebhookInfo extends AbstractContext {

	def getWebhookInfo(Map params = [:]) {
		api.go(new Some('getWebhookInfo', params))
	}
}
