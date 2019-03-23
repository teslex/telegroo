package tech.teslex.telegroo.simple.update.closure

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.simple.update.SimpleMessageUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
class SimpleClosureMessageUpdateHandler implements SimpleMessageUpdateHandler {

	UpdateType updateType

	Pattern pattern

	Closure closure

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
	void handle(SimpleMethodsContext context) {
		closure.delegate = context
		closure()
	}
}
