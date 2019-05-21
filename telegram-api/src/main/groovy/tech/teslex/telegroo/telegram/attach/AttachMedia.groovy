package tech.teslex.telegroo.telegram.attach

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.MediaType
import tech.teslex.telegroo.telegram.types.input.*

@CompileStatic
class AttachMedia {

	static InputMedia attach(InputFile inputFile) {
		switch (inputFile.mediaType) {
			case MediaType.ANIMATION: animation(inputFile); break
			case MediaType.AUDIO: audio(inputFile); break
			case MediaType.PHOTO: photo(inputFile); break
			case MediaType.VIDEO: video(inputFile); break
			default: document(inputFile); break
		}
	}

	static InputMediaAnimation animation(InputFile inputFile) {
		new InputMediaAnimation().media(inputFile)
	}

	static InputMediaAnimation animation(File animationFile) {
		animation(Attach.animation(animationFile))
	}

	static InputMediaAudio audio(InputFile inputFile) {
		new InputMediaAudio().media(inputFile)
	}

	static InputMediaAudio audio(File audioFile) {
		audio(Attach.audio(audioFile))
	}

	static InputMediaDocument document(InputFile inputFile) {
		new InputMediaDocument().media(inputFile)
	}

	static InputMediaDocument document(File documentFile) {
		document(Attach.document(documentFile))
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
