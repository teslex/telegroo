package tech.teslex.telegroo.telegram.attach

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType
import tech.teslex.telegroo.telegram.types.input.*

@CompileStatic
class AttachMedia {

	static InputMedia attach(InputFile inputFile) {

		switch (inputFile.mediaType) {
			case MediaType.PHOTO: photo(inputFile); break
			case MediaType.VIDEO: video(inputFile); break
		}
	}

	static InputMediaPhoto photo(InputFile inputFile) {
		new InputMediaPhoto().media(inputFile)
	}

	static InputMediaPhoto photo(File photoFile) {
		photo(Attach.photo(photoFile))
	}

	static InputMediaVideo video(InputFile inputFile) {
		new InputMediaVideo().media(inputFile)
	}

	static InputMediaVideo video(File videoFile) {
		video(Attach.video(videoFile))
	}
}
