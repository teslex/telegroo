package tech.teslex.telegroo.telegram.api.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
class PhotoSize {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Photo width
	 */
	Integer width

	/**
	 * Photo height
	 */
	Integer height

	/**
	 * Optional. File size
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize
}
