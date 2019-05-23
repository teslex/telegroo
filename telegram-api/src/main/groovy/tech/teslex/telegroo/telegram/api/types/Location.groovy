package tech.teslex.telegroo.telegram.api.types


import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
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
