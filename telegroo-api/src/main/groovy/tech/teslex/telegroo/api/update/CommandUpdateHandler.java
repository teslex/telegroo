package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;

public interface CommandUpdateHandler<T extends Context> extends MessageUpdateHandler<T> {

	default Boolean useCommandSymbol() {
		return true;
	}

	default String getCommandSymbol() {
		return "/";
	}
}