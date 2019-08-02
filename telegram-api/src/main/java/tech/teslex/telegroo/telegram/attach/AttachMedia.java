package tech.teslex.telegroo.telegram.attach;

import tech.teslex.telegroo.telegram.api.types.input.InputMediaPhoto;
import tech.teslex.telegroo.telegram.api.types.input.InputMediaVideo;

import java.io.File;

public final class AttachMedia {

	public static InputMediaPhoto photo(InputFile inputFile) {
		return InputMediaPhoto.builder().media(inputFile).build();
	}

	public static InputMediaPhoto photo(File photoFile) {
		return photo(Attach.photo(photoFile));
	}

	public static InputMediaVideo video(InputFile inputFile) {
		return InputMediaVideo.builder().media(inputFile).build();
	}

	public static InputMediaVideo video(File videoFile) {
		return video(Attach.video(videoFile));
	}

}
