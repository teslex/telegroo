package tech.teslex.telegroo.telegram.types.input

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType

@CompileStatic
class Attach {

	static UrlInputFile byUrl(String fileUrl) {
		new UrlInputFile(fileUrl)
	}

	static IdInputFile byId(String fileId) {
		new IdInputFile(fileId)
	}

	static FileInputFile document(File file, MediaType type = MediaType.DOCUMENT) {
		new FileInputFile(file, type)
	}

	static FileInputFile document(String file, MediaType type = MediaType.DOCUMENT) {
		new FileInputFile(new File(file), type)
	}

	static FileInputFile photo(File photoFile) {
		document(photoFile, MediaType.PHOTO)
	}

	static FileInputFile photo(String photoFile) {
		document(photoFile, MediaType.PHOTO)
	}

	static FileInputFile animation(File photoFile) {
		document(photoFile, MediaType.ANIMATION)
	}

	static FileInputFile animation(String photoFile) {
		document(photoFile, MediaType.ANIMATION)
	}

	static FileInputFile sticker(File photoFile) {
		document(photoFile, MediaType.STICKER)
	}

	static FileInputFile sticker(String photoFile) {
		document(photoFile, MediaType.STICKER)
	}

	static FileInputFile video(File photoFile) {
		document(photoFile, MediaType.VIDEO)
	}

	static FileInputFile video(String photoFile) {
		document(photoFile, MediaType.VIDEO)
	}

	static FileInputFile videoNote(File photoFile) {
		document(photoFile, MediaType.VIDEO_NOTE)
	}

	static FileInputFile videoNote(String photoFile) {
		document(photoFile, MediaType.VIDEO_NOTE)
	}

	static FileInputFile voice(File photoFile) {
		document(photoFile, MediaType.VOICE)
	}

	static FileInputFile voice(String photoFile) {
		document(photoFile, MediaType.VOICE)
	}

	static FileInputFile audio(File photoFile) {
		document(photoFile, MediaType.AUDIO)
	}

	static FileInputFile audio(String photoFile) {
		document(photoFile, MediaType.AUDIO)
	}
}
