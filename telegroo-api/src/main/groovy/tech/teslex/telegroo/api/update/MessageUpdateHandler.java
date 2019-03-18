package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.regex.Pattern;

public interface MessageUpdateHandler extends UpdateHandler {

	Pattern getPattern();

	@Override
	default UpdateType getType() {
		return UpdateType.MESSAGE;
	}
}