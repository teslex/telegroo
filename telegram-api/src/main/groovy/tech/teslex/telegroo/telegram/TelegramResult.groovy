package tech.teslex.telegroo.telegram

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic

@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class TelegramResult<T> {

	Boolean ok

	@JsonProperty(required = false)
	String description

	@JsonProperty(required = false)
	T result

	@JsonProperty(value = 'error_code', required = false)
	Integer errorCode

	@JsonProperty(required = false)
	def parameters // todo: implement it
}