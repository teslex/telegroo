package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.Context

@CompileStatic
interface CommandUpdateHandler<T extends Context> extends MessageUpdateHandler<T> {

	default Boolean useCommandSymbol() {
		return true
	}

	default String getCommandSymbol() {
		return "/"
	}
}