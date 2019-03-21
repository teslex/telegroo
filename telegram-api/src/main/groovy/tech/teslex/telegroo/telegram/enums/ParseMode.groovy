package tech.teslex.telegroo.telegram.enums

import groovy.transform.CompileStatic

@CompileStatic
enum ParseMode {

	MARKDOWN('Markdown'),
	HTML('HTML')

	private String value

	String getValue() {
		return this.value
	}

	private ParseMode(String value) {
		this.value = value
	}

	static ParseMode fromString(String string) {
		values().find { it.value == string }
	}
}
