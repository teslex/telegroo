package tech.teslex.telegroo.telegram.types.input

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.types.*

@CompileStatic
class AttachMedia {

	static InputMediaAnimation animation(InputFile inputFile) {
		new InputMediaAnimation().media(inputFile)
	}

	static InputMediaAudio audio(InputFile inputFile) {
		new InputMediaAudio().media(inputFile)
	}

	static InputMediaDocument document(InputFile inputFile) {
		new InputMediaDocument().media(inputFile)
	}

	static InputMediaPhoto photo(InputFile inputFile) {
		new InputMediaPhoto().media(inputFile)
	}

	static InputMediaVideo video(InputFile inputFile) {
		new InputMediaVideo().media(inputFile)
	}
}
