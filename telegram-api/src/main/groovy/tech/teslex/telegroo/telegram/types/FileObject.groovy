package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class FileObject {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Optional. File size, if known
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize

	/**
	 * Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
	 */
	@JsonProperty(value = 'file_path', required = false)
	String filePath
}