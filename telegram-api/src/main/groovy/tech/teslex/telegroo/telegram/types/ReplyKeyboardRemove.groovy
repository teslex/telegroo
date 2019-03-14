package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ReplyKeyboardRemove {

	/**
	 * Optional. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 *
	 * Example: A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
	 */
	Boolean selective
}
