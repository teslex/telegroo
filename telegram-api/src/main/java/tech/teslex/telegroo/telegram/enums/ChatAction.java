package tech.teslex.telegroo.telegram.enums;

import java.util.Arrays;

public enum ChatAction {

	TYPING("typing"),
	UPLOAD_PHOTO("upload_photo"),
	RECORD_VIDEO("record_video"),
	UPLOAD_VIDEO("upload_video"),
	RECORD_AUDIO("record_audio"),
	UPLOAD_AUDIO("upload_audio"),
	UPLOAD_DOCUMENT("upload_document"),
	FIND_LOCATION("find_location"),
	RECORD_VIDEO_NOTE("record_video_note"),
	UPLOAD_VIDEO_NOTE("upload_video_note");

	private String value;

	ChatAction(String value) {
		this.value = value;
	}

	public static ChatAction fromString(final String string) {
		return Arrays.stream(values())
				.filter(chatAction -> chatAction.getValue().equals(string))
				.findFirst()
				.orElseThrow();
	}

	public String getValue() {
		return this.value;
	}
}
