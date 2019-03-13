package tech.teslex.telegroo.telegram.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.ParseMode

@CompileStatic
trait ParseModeTrait {

	/**
	 * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	String getParseMode() {
		this.parseMode
	}

	void setParseMode(String parseMode) {
		this.parseMode = parseMode
	}

	@JsonIgnore
	void setParseMode(ParseMode parseMode) {
		this.parseMode = parseMode.mode
	}
}