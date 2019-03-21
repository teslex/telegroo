package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Voice {

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
