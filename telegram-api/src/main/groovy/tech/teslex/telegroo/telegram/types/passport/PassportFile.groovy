package tech.teslex.telegroo.telegram.types.passport


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class PassportFile {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * File size
	 */
	@JsonProperty(value = 'file_size')
	Integer fileSize

	/**
	 * Unix time when the file was uploaded
	 */
	@JsonProperty(value = 'file_date')
	Integer fileDate
}
