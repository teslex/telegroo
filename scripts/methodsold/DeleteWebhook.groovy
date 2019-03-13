package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait DeleteWebhook extends AbstractContext {

	def deleteWebhook(Map params = [:]) {
		api.go(new Some('deleteWebhook', params))
	}
}
