package tech.teslex.telegroo.telegram.attach;

import tech.teslex.telegroo.telegram.enums.util.MediaType;

public class IdInputFile extends InputFile<String> {

	public IdInputFile(String file, MediaType mediaType) {
		super(file, mediaType);
	}

	public IdInputFile(String file) {
		this(file, MediaType.DOCUMENT);
	}
}
