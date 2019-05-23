package tech.teslex.telegroo.telegram.attach

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.api.types.input.InputMediaPhoto
import tech.teslex.telegroo.telegram.api.types.input.InputMediaVideo

@CompileStatic
class AttachMedia {

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
