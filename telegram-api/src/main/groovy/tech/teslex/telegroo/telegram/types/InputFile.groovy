package tech.teslex.telegroo.telegram.types

import groovy.transform.CompileStatic

/**
 * This object represents the contents of a file to be uploaded. Must be posted using multipart/form-data in the usual way that files are uploaded via the browser.
 */
@CompileStatic
class InputFile<T> {

	T file

	String mediaType = 'document'

	Boolean isId = false

	InputFile(String file, Boolean isId = false) {
		this.file = file as T
		this.isId = isId
	}

	InputFile(File file, String mediaType = 'document') {
		this.file = file as T
		this.mediaType = mediaType
	}

	static InputFile<String> ofUrl(String fileUrl) {
		new InputFile<String>(fileUrl, false)
	}

	static InputFile<String> ofId(String fileId) {
		new InputFile<String>(fileId, true)
	}

	static InputFile<File> ofFile(File file, String type = 'document') {
		new InputFile<File>(file, type)
	}

	static InputFile<File> ofFile(String file, String type = 'document') {
		new InputFile<File>(new File(file), type)
	}

	static InputFile<File> ofPhoto(File photoFile) {
		ofFile(photoFile, 'photo')
	}

	static InputFile<File> ofPhoto(String photoFile) {
		ofFile(photoFile, 'photo')
	}
}
