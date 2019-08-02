package tech.teslex.telegroo.telegram.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelegramResult<T> {

	private boolean ok;

	@JsonProperty(required = false)
	private String description;

	@JsonProperty(required = false)
	private T result;

	@JsonProperty(value = "error_code", required = false)
	private Integer errorCode;

	@JsonProperty(required = false)
	private Object parameters;

	public boolean isOk() {
		return ok;
	}
}
