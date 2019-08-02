package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.enums.UpdateType;

public interface EntityUpdateListener<C extends Context> extends UpdateListener<C> {

	String getEntity();

	@Override
	default UpdateType getType() {
		return UpdateType.MESSAGE;
	}
}