package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.types.games.Game
import tech.teslex.telegroo.telegram.types.passport.PassportData
import tech.teslex.telegroo.telegram.types.payments.Invoice
import tech.teslex.telegroo.telegram.types.payments.SuccessfulPayment
import tech.teslex.telegroo.telegram.types.stickers.Sticker

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Message {

	/**
	 * Unique message identifier inside this chat
	 */
	@JsonProperty(value = 'message_id')
	Integer messageId

	/**
	 * Optional. Sender, empty for messages sent to channels
	 */
	@JsonProperty(required = false)
	User from

	/**
	 * Date the message was sent in Unix time
	 */
	Integer date

	/**
	 * Conversation the message belongs to
	 */
	Chat chat

	/**
	 * Optional. For forwarded messages, sender of the original message
	 */
	@JsonProperty(value = 'forward_from', required = false)
	User forwardFrom

	/**
	 * Optional. For messages forwarded from channels, information about the original channel
	 */
	@JsonProperty(value = 'forward_from_chat', required = false)
	Chat forwardFromChat

	/**
	 * Optional. For messages forwarded from channels, identifier of the original message in the channel
	 */
	@JsonProperty(value = 'forward_from_message_id', required = false)
	Integer forwardFromMessageId

	/**
	 * Optional. For messages forwarded from channels, signature of the post author if present
	 */
	@JsonProperty(value = 'forward_signature', required = false)
	String forwardSignature

	/**
	 * Optional. For forwarded messages, date the original message was sent in Unix time
	 */
	@JsonProperty(value = 'forward_date', required = false)
	Integer forwardDate

	/**
	 * Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
	 */
	@JsonProperty(value = 'reply_to_message', required = false)
	Message replyToMessage

	/**
	 * Optional. Date the message was last edited in Unix time
	 */
	@JsonProperty(value = 'edit_date', required = false)
	Integer editDate

	/**
	 * Optional. The unique identifier of a media message group this message belongs to
	 */
	@JsonProperty(value = 'media_group_id', required = false)
	String mediaGroupId

	/**
	 * Optional. Signature of the post author for messages in channels
	 */
	@JsonProperty(value = 'author_signature', required = false)
	String authorSignature

	/**
	 * Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
	 */
	@JsonProperty(required = false)
	String text

	/**
	 * Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
	 */
	@JsonProperty(required = false)
	List<MessageEntity> entities

	/**
	 * Optional. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
	 */
	@JsonProperty(value = 'caption_entities', required = false)
	List<MessageEntity> captionEntities

	/**
	 * Optional. Message is an audio file, information about the file
	 */
	@JsonProperty(required = false)
	Audio audio

	/**
	 * Optional. Message is a general file, information about the file
	 */
	@JsonProperty(required = false)
	Document document

	/**
	 * Optional. Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set
	 */
	@JsonProperty(required = false)
	Animation animation

	/**
	 * Optional. Message is a game, information about the game. More about games »
	 */
	@JsonProperty(required = false)
	Game game

	/**
	 * Optional. Message is a photo, available sizes of the photo
	 */
	@JsonProperty(required = false)
	List<PhotoSize> photo

	/**
	 * Optional. Message is a sticker, information about the sticker
	 */
	@JsonProperty(required = false)
	Sticker sticker

	/**
	 * Optional. Message is a video, information about the video
	 */
	@JsonProperty(required = false)
	Video video

	/**
	 * Optional. Message is a voice message, information about the file
	 */
	@JsonProperty(required = false)
	Voice voice

	/**
	 * Optional. Message is a video note, information about the video message
	 */
	@JsonProperty(value = 'video_note', required = false)
	VideoNote videoNote

	/**
	 * Optional. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Optional. Message is a shared contact, information about the contact
	 */
	@JsonProperty(required = false)
	Contact contact

	/**
	 * Optional. Message is a shared location, information about the location
	 */
	@JsonProperty(required = false)
	Location location

	/**
	 * Optional. Message is a venue, information about the venue
	 */
	@JsonProperty(required = false)
	Venue venue

	/**
	 * Optional. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
	 */
	@JsonProperty(value = 'new_chat_members', required = false)
	List<User> newChatMembers

	/**
	 * Optional. A member was removed from the group, information about them (this member may be the bot itself)
	 */
	@JsonProperty(value = 'left_chat_member', required = false)
	User leftChatMember

	/**
	 * Optional. A chat title was changed to this value
	 */
	@JsonProperty(value = 'new_chat_title', required = false)
	String newChatTitle

	/**
	 * Optional. A chat photo was change to this value
	 */
	@JsonProperty(value = 'new_chat_photo', required = false)
	List<PhotoSize> newChatPhoto

	/**
	 * Optional. Service message: the chat photo was deleted
	 */
	@JsonProperty(value = 'delete_chat_photo', required = false)
	Boolean deleteChatPhoto

	/**
	 * Optional. Service message: the group has been created
	 */
	@JsonProperty(value = 'group_chat_created', required = false)
	Boolean groupChatCreated

	/**
	 * Optional. Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
	 */
	@JsonProperty(value = 'supergroup_chat_created', required = false)
	Boolean supergroupChatCreated

	/**
	 * Optional. Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
	 */
	@JsonProperty(value = 'channel_chat_created', required = false)
	Boolean channelChatCreated

	/**
	 * Optional. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
	 */
	@JsonProperty(value = 'migrate_to_chat_id', required = false)
	Integer migrateToChatId

	/**
	 * Optional. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
	 */
	@JsonProperty(value = 'migrate_from_chat_id', required = false)
	Integer migrateFromChatId

	/**
	 * Optional. Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
	 */
	@JsonProperty(value = 'pinned_message', required = false)
	Message pinnedMessage

	/**
	 * Optional. Message is an invoice for a payment, information about the invoice. More about payments »
	 */
	@JsonProperty(required = false)
	Invoice invoice

	/**
	 * Optional. Message is a service message about a successful payment, information about the payment. More about payments »
	 */
	@JsonProperty(value = 'successful_payment', required = false)
	SuccessfulPayment successfulPayment

	/**
	 * Optional. The domain name of the website on which the user has logged in. More about Telegram Login »
	 */
	@JsonProperty(value = 'connected_website', required = false)
	String connectedWebsite

	/**
	 * Optional. Telegram Passport data
	 */
	@JsonProperty(value = 'passport_data', required = false)
	PassportData passportData
}
