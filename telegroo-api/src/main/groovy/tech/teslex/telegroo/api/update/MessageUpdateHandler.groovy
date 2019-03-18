package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.UpdateType

import java.util.regex.Pattern

// waiting for groovy 3 with default methods...
@CompileStatic
trait MessageUpdateHandler implements UpdateHandler {

	abstract Pattern getPattern();

	@Override
	UpdateType getType() {
		return UpdateType.MESSAGE
	}
}