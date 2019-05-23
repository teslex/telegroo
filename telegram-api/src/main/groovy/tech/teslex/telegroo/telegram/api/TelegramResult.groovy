package tech.teslex.telegroo.telegram.api


import com.fasterxml.jackson.annotation.JsonProperty

@TypeAnnotations
class TelegramResult<T> {

	Boolean ok

	@JsonProperty(required = false)
	String description

	@JsonProperty(required = false)
	T result

	@JsonProperty(value = 'error_code', required = false)
	Integer errorCode

	@JsonProperty(required = false)
	def parameters
}