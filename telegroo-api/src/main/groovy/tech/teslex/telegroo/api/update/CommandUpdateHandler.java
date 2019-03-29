package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.api.context.Context;

import java.util.regex.Pattern;

public interface CommandUpdateHandler<T extends Context> extends MessageUpdateHandler<T> {

	default Boolean useCommandSymbol() {
		return true;
	}

	default String getCommandSymbol() {
		return "/";
	}

	default Pattern getPatternWithCommandSymbol() {
		return Pattern.compile(getCommandSymbol() + getPattern().pattern());
	}
}