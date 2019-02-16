package tech.teslex.telegroo.api.enums

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
}
