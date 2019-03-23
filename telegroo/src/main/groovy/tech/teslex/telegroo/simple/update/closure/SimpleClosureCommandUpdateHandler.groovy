package tech.teslex.telegroo.simple.update.closure

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
class SimpleClosureCommandUpdateHandler implements SimpleCommandUpdateHandler {

	UpdateType updateType

	Pattern pattern

	Closure closure

	SimpleClosureCommandUpdateHandler(Pattern pattern, Closure closure) {
		this.updateType = UpdateType.MESSAGE
		this.pattern = pattern
		this.closure = closure
	}

	SimpleClosureCommandUpdateHandler(String pattern, Closure closure) {
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
