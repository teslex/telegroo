package tech.teslex.telegroo.simple.update.closure

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.simple.update.SimpleUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

@CompileStatic
class SimpleClosureUpdateHandler implements SimpleUpdateHandler {

	UpdateType updateType

	Closure closure

	SimpleClosureUpdateHandler(Closure closure) {
		this.updateType = UpdateType.UPDATE
		this.closure = closure
	}

	SimpleClosureUpdateHandler(UpdateType updateType, Closure closure) {
		this.updateType = updateType
		this.closure = closure
	}

	@Override
	void handle(MethodsContext context) {
		closure.delegate = context
		closure()
	}
}
