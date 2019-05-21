package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.List;

public interface EntitiesUpdateHandler<C extends Context> extends UpdateHandler<C> {

	List<String> getEntities();

	@Override
	default UpdateType getType() {
		return UpdateType.MESSAGE;
	}
}