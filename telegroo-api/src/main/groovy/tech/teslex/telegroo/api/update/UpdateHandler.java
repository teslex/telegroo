package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.telegram.enums.UpdateType;

public interface UpdateHandler {

	void handle(MethodsContext context);

	default UpdateType getType() {
		return UpdateType.UPDATE;
	}
}
