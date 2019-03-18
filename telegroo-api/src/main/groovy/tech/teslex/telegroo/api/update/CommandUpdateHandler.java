package tech.teslex.telegroo.api.update;

public interface CommandUpdateHandler extends MessageUpdateHandler {

	default Boolean useCommandSymbol() {
		return true;
	}

	default String getCommandSymbol() {
		return "/";
	}
}