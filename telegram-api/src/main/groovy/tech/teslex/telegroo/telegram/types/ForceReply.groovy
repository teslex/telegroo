package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ForceReply {

	/**
	 * Optional. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 */
	@JsonProperty(required = false)
	Boolean selective
}
