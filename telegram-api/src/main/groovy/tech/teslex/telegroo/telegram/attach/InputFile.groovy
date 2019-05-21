package tech.teslex.telegroo.telegram.attach

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType

@CompileStatic
abstract class InputFile<T> {

	protected final T file

	protected final MediaType mediaType

	InputFile(T file, MediaType mediaType = MediaType.DOCUMENT) {
		this.file = file
		this.mediaType = mediaType
	}

	T getFile() {
		file
	}

	MediaType getMediaType() {
		mediaType
	}
}
