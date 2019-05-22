package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.List;

public interface CallbackQueryUpdateHandler<C extends Context> extends UpdateHandler<C> {

	List<String> getCallbackData();

	@Override
	default UpdateType getType() {
		return UpdateType.CALLBACK_QUERY;
	}
}