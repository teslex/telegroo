package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class Video {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Video width as defined by sender
	 */
	Integer width

	/**
	 * Video height as defined by sender
	 */
	Integer height

	/**
	 * Duration of the video in seconds as defined by sender
	 */
	Integer duration

	/**
	 * Optional. Video thumbnail
	 */
	@JsonProperty(required = false)
	PhotoSize thumb

	/**
	 * Optional. Mime value of a file as defined by sender
	 */
	@JsonProperty(value = 'mime_type', required = false)
	String mimeType

	/**
	 * Optional. File size
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize
}
