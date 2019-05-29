package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.enums.UpdateType;

public interface CallbackQueryUpdateListener<C extends Context> extends UpdateListener<C> {

	String getCallbackData();

	@Override
	default UpdateType getType() {
		return UpdateType.CALLBACK_QUERY;
	}
}