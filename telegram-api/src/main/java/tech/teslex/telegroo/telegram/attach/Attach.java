package tech.teslex.telegroo.telegram.attach;

import tech.teslex.telegroo.telegram.enums.util.MediaType;

import java.io.File;

public final class Attach {

	public static UrlInputFile byUrl(String fileUrl) {
		return new UrlInputFile(fileUrl);
	}

	public static IdInputFile byId(String fileId) {
		return new IdInputFile(fileId);
	}

	public static FileInputFile document(File file, MediaType type) {
		return new FileInputFile(file, type);
	}

	public static FileInputFile document(File file) {
		return Attach.document(file, MediaType.DOCUMENT);
	}

	public static FileInputFile photo(File photoFile) {
		return document(photoFile, MediaType.PHOTO);
	}

	public static FileInputFile animation(File photoFile) {
		return document(photoFile, MediaType.ANIMATION);
	}

	public static FileInputFile sticker(File photoFile) {
		return document(photoFile, MediaType.STICKER);
	}

	public static FileInputFile video(File photoFile) {
		return document(photoFile, MediaType.VIDEO);
	}

	public static FileInputFile videoNote(File photoFile) {
		return document(photoFile, MediaType.VIDEO_NOTE);
	}

	public static FileInputFile voice(File photoFile) {
		return document(photoFile, MediaType.VOICE);
	}

	public static FileInputFile audio(File photoFile) {
		return document(photoFile, MediaType.AUDIO);
	}
}
