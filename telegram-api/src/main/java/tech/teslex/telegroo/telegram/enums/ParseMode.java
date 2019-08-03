package tech.teslex.telegroo.telegram.enums;

import java.util.Arrays;

public enum ParseMode {

	MARKDOWN("Markdown"),
	HTML("HTML");

	private String value;

	ParseMode(String value) {
		this.value = value;
	}

	public static ParseMode fromString(final String string) {
		return Arrays.stream(values())
				.filter(parseMode -> parseMode.getValue().equals(string))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public String getValue() {
		return this.value;
	}
}
