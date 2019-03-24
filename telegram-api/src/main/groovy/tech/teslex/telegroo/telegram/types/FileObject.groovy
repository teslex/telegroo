package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

/**
 * This object represents the contents of a file to be uploaded. Must be posted using multipart/form-data in the usual way that files are uploaded via the browser.
 */
@TypeAnnotations
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