package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class Audio {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Duration of the audio in seconds as defined by sender
	 */
	Integer duration

	/**
	 * Optional. Performer of the audio as defined by sender or by audio tags
	 */
	@JsonProperty(required = false)
	String performer

	/**
	 * Optional. Title of the audio as defined by sender or by audio tags
	 */
	@JsonProperty(required = false)
	String title

	/**
	 * Optional. MIME value of the file as defined by sender
	 */
	@JsonProperty(value = 'mime_type', required = false)
	String mimeType

	/**
	 * Optional. File size
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize

	/**
	 * Optional. Thumbnail of the album cover to which the music file belongs
	 */
	@JsonProperty(required = false)
	PhotoSize thumb
}
