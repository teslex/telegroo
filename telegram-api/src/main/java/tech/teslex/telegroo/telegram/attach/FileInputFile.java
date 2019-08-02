package tech.teslex.telegroo.telegram.attach;

import tech.teslex.telegroo.telegram.enums.util.MediaType;

import java.io.File;

public class FileInputFile extends InputFile<File> {

	public FileInputFile(File file, MediaType mediaType) {
		super(file, mediaType);
	}

	public FileInputFile(File file) {
		this(file, MediaType.DOCUMENT);
	}
}
