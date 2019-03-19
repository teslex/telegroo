package tech.teslex.telegroo.telegram.types

import groovy.transform.CompileStatic

@CompileStatic
class InputFile<T> {

	T file

	String mediaType = 'document'

	Boolean isId = false

	Boolean isFile = false

	Boolean isUrl = false

	InputFile(String fileUrl, Boolean isId = false) {
		this.file = fileUrl as T
		this.isId = isId
		this.isUrl = !isId
	}

	InputFile(File file, String mediaType = 'document') {
		this.file = file as T
		this.mediaType = mediaType

		this.isFile = true
		this.isId = false
		this.isUrl = false
	}

	static InputFile<String> ofUrl(String fileUrl) {
		new InputFile<String>(fileUrl, false)
	}

	static InputFile<String> ofId(String fileId) {
		new InputFile<String>(fileId, true)
	}

	static InputFile<File> ofDocument(File file, String type = 'document') {
		new InputFile<File>(file, type)
	}

	static InputFile<File> ofDocument(String file, String type = 'document') {
		new InputFile<File>(new File(file), type)
	}

	static InputFile<File> ofPhoto(File photoFile) {
		ofDocument(photoFile, 'photo')
	}

	static InputFile<File> ofPhoto(String photoFile) {
		ofDocument(photoFile, 'photo')
	}

	static InputFile<File> ofAnimation(File photoFile) {
		ofDocument(photoFile, 'animation')
	}

	static InputFile<File> ofAnimation(String photoFile) {
		ofDocument(photoFile, 'animation')
	}

	static InputFile<File> ofSticker(File photoFile) {
		ofDocument(photoFile, 'sticker')
	}

	static InputFile<File> ofSticker(String photoFile) {
		ofDocument(photoFile, 'sticker')
	}

	static InputFile<File> ofVideo(File photoFile) {
		ofDocument(photoFile, 'video')
	}

	static InputFile<File> ofVideo(String photoFile) {
		ofDocument(photoFile, 'video')
	}

	static InputFile<File> ofVideoNote(File photoFile) {
		ofDocument(photoFile, 'video_note')
	}

	static InputFile<File> ofVideoNote(String photoFile) {
		ofDocument(photoFile, 'video_note')
	}

	static InputFile<File> ofVoice(File photoFile) {
		ofDocument(photoFile, 'voice')
	}

	static InputFile<File> ofVoice(String photoFile) {
		ofDocument(photoFile, 'voice')
	}

	static InputFile<File> ofAudio(File photoFile) {
		ofDocument(photoFile, 'audio')
	}

	static InputFile<File> ofAudio(String photoFile) {
		ofDocument(photoFile, 'audio')
	}
}
