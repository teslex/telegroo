package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.enums.UpdateType;

public interface UpdateHandler<T extends Context> {

	void handle(T context);

	default UpdateType getType() {
		return UpdateType.UPDATE;
	}
}
