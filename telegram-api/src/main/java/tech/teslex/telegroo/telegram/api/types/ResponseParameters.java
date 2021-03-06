package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseParameters {
	/**
	 * Optional. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float value are safe for storing this identifier.
	 */
	@JsonProperty(value = "migrate_to_chat_id", required = false)
	private Integer migrateToChatId;
	/**
	 * Optional. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
	 */
	@JsonProperty(value = "retry_after", required = false)
	private Integer retryAfter;
}
