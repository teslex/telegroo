package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class VideoNote {

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(value = 'file_id')
	String fileId

	/**
	 * Video width and height (diameter of the video message) as defined by sender
	 */
	Integer length

	/**
	 * Duration of the video in seconds as defined by sender
	 */
	Integer duration

	/**
	 * Optional. Video thumbnail
	 */
	@JsonProperty(required = false)
	PhotoSize thumb

	/**
	 * Optional. File size
	 */
	@JsonProperty(value = 'file_size', required = false)
	Integer fileSize
}
