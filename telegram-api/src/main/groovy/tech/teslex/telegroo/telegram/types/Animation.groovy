package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 */
@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Animation {

	/**
	 * Unique file identifier
	 */
	@JsonProperty('file_id')
	String fileId

	/**
	 * Video width as defined by sender
	 */
	Integer width

	/**
	 * Video height as defined by senderx
	 */
	Integer height

	/**
	 * Duration of the video in seconds as defined by sender
	 */
	Integer duration

	/**
	 * Optional. Animation thumbnail as defined by sender
	 */
	@JsonProperty(required = false)
	PhotoSize thumb

	/**
	 * Optional. Original animation filename as defined by sender
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
