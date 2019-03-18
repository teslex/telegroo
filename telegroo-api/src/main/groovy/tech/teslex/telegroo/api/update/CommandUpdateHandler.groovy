package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.UpdateType

// waiting for groovy 3 with default methods...
@CompileStatic
trait CommandUpdateHandler extends MessageUpdateHandler {

	@Override
	UpdateType getType() {
		return UpdateType.MESSAGE
	}
}