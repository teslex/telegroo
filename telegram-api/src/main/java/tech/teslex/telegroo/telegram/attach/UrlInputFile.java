package tech.teslex.telegroo.telegram.attach;

import tech.teslex.telegroo.telegram.enums.util.MediaType;

public class UrlInputFile extends InputFile<String> {

	public UrlInputFile(String file, MediaType mediaType) {
		super(file, mediaType);
	}

	public UrlInputFile(String file) {
		this(file, MediaType.DOCUMENT);
	}
}
