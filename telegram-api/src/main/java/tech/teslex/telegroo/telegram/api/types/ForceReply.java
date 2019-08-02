package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForceReply {
	/**
	 * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
	 */
	@JsonProperty(value = "force_reply")
	private Boolean forceReply = true;
	/**
	 * Optional. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 */
	@JsonProperty(required = false)
	private Boolean selective;
}
