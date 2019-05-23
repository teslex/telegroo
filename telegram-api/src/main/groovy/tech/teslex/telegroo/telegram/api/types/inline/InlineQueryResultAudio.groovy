package tech.teslex.telegroo.telegram.api.types.inline


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup

/**
 * Represents a link to an mp3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use input_message_content to send a message with the specified content instead of the audio.
 */
@TypeAnnotations
class InlineQueryResultAudio extends InlineQueryResult {

	/**
	 * Type of the result, must be audio
	 */
	String type = 'audio'

	/**
	 * Unique identifier for this result, 1-64 bytes
	 */
	String id

	/**
	 * A valid URL for the audio file
	 */
	@JsonProperty(value = 'audio_url')
	String audioUrl

	/**
	 * Title
	 */
	String title

	/**
	 * Optional. Caption, 0-1024 characters
	 */
	@JsonProperty(required = false)
	String caption

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
	 */
	@JsonProperty(value = 'parse_mode', required = false)
	String parseMode

	/**
	 * Optional. Performer
	 */
	@JsonProperty(required = false)
	String performer

	/**
	 * Optional. Audio duration in seconds
	 */
	@JsonProperty(value = 'audio_duration', required = false)
	Integer audioDuration

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(value = 'reply_markup', required = false)
	InlineKeyboardMarkup replyMarkup

	/**
	 * Optional. Content of the message to be sent instead of the audio
	 */
	@JsonProperty(value = 'input_message_content', required = false)
	InputMessageContent inputMessageContent
}
