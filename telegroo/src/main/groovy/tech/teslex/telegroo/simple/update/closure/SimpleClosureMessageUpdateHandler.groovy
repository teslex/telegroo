package tech.teslex.telegroo.simple.update.closure

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.MessageUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
class SimpleClosureMessageUpdateHandler implements MessageUpdateHandler {

	final UpdateType updateType

	final Pattern pattern

	final Closure closure

	SimpleClosureMessageUpdateHandler(Pattern pattern, Closure closure) {
		this.updateType = UpdateType.MESSAGE
		this.pattern = pattern
		this.closure = closure
	}

	SimpleClosureMessageUpdateHandler(String pattern, Closure closure) {
		this.updateType = UpdateType.MESSAGE
		this.pattern = Pattern.compile(pattern)
		this.closure = closure
	}

	@Override
	void handle(MethodsContext context) {
		closure.delegate = context
		closure()
	}
}
