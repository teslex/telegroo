package tech.teslex.telegroo.telegram.types.input

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType

@CompileStatic
class UrlInputFile extends InputFile<String> {

	UrlInputFile(String file, MediaType mediaType = MediaType.DOCUMENT) {
		super(file, mediaType)
	}
}