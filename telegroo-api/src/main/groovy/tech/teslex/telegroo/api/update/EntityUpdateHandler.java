package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.List;

public interface EntityUpdateHandler<C extends Context> extends UpdateHandler<C> {

	String getEntity();

	@Override
	default UpdateType getType() {
		return UpdateType.MESSAGE;
	}
}