package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.enums.UpdateType

@CompileStatic
interface UpdateHandler<T extends Context> {

	void handle(T context)

	default UpdateType getType() {
		return UpdateType.UPDATE
	}
}
