package tech.teslex.telegroo.telegram.attach

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType

@CompileStatic
class IdInputFile extends InputFile<String> {

	IdInputFile(String file, MediaType mediaType = MediaType.DOCUMENT) {
		super(file, mediaType)
	}
}