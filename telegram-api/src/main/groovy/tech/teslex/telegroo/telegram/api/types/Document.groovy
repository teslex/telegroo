package tech.teslex.telegroo.telegram.api.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
class Document {

	/**
	 * Unique file identifier
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Optional. Document thumbnail as defined by sender
	 */
	@JsonProperty(required = false)
	PhotoSize thumb

	/**
	 * Optional. Original filename as defined by sender
	 */
	@JsonProperty(value = 'file_name', required = false)
	String fileName

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
}
