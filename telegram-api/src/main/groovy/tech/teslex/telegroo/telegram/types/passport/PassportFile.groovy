package tech.teslex.telegroo.telegram.types.passport

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
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
