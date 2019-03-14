package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * abstract
 * description
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class aMethodObject implements MethodObject {


	/**
	 * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 *
	 * InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	def replyMarkup

	@Override
	String getPathMethod() {
		'pathMethod'
	}

//	void setParseMode(String parseMode) {
//		this.parseMode = parseMode
//	}
//
//	@JsonIgnore
//	void setParseMode(ParseMode parseMode) {
//		this.parseMode = parseMode.mode
//	}
}
