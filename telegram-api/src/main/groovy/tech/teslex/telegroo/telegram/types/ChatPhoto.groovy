package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class ChatPhoto {

	/**
	 * Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
	 */
	@JsonProperty(value = 'small_file_id')
	String smallFileId

	/**
	 * Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
	 */
	@JsonProperty(value = 'big_file_id')
	String bigFileId
}
