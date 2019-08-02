package tech.teslex.telegroo.telegram.attach;

import tech.teslex.telegroo.telegram.enums.util.MediaType;

public abstract class InputFile<T> {

	protected final T file;

	protected final MediaType mediaType;

	public InputFile(T file, MediaType mediaType) {
		this.file = file;
		this.mediaType = mediaType;
	}

	public InputFile(T file) {
		this(file, MediaType.DOCUMENT);
	}

	public T getFile() {
		return file;
	}

	public MediaType getMediaType() {
		return mediaType;
	}
}
