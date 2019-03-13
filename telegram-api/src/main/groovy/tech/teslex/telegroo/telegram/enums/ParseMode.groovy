package tech.teslex.telegroo.telegram.enums

import groovy.transform.CompileStatic

@CompileStatic
enum ParseMode {

	MARKDOWN('Markdown'),
	HTML('HTML')

	private String mode

	String getMode() {
		return this.mode
	}

	private ParseMode(String mode) {
		this.mode = mode
	}

	static ParseMode fromString(String string) {
		values().find { it.mode == string }
	}
}
