package tech.teslex.telegroo.telegram.types

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
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
