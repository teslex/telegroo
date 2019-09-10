package tech.teslex.telegroo.telegram.enums;

import java.util.Arrays;

public enum ParseMode {

	MARKDOWN("Markdown"),
	HTML("HTML");

	private String mode;

	ParseMode(String mode) {
		this.mode = mode;
	}

	public static ParseMode fromString(final String string) {
		return Arrays.stream(values())
				.filter(parseMode -> parseMode.getMode().equals(string))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public String getMode() {
		return mode;
	}
}
