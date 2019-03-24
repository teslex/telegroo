package tech.teslex.telegroo.telegram.types


import tech.teslex.telegroo.telegram.TypeAnnotations

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
