package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait GetUpdates extends AbstractContext {

	def getUpdates(offset = 0, limit = 0, timeout = 0, List<String> allowedUpdates = []) {
		api.go(new Some('getUpdates', [offset: offset]))
	}
}