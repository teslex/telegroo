package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
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
	 * Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty(value = 'mime_type', required = false)
	String mimeType

	/**
	 * Optional. File size
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize
}
