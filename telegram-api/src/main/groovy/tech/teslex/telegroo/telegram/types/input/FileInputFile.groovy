package tech.teslex.telegroo.telegram.types.input

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType

@CompileStatic
class FileInputFile extends InputFile<File> {

	FileInputFile(File file, MediaType mediaType = MediaType.DOCUMENT) {
		super(file, mediaType)
	}
}