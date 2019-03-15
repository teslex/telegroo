package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class Location {

	/**
	 * Longitude as defined by sender
	 */
	Float longitude

	/**
	 * Latitude as defined by sender
	 */
	Float latitude
}
