package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

@CompileStatic
interface MessageUpdateHandler<T extends Context> extends UpdateHandler<T> {

	Pattern getPattern()

	@Override
	default UpdateType getType() {
		return UpdateType.MESSAGE
	}
}