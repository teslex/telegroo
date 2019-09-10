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

	private String action;

	ChatAction(String action) {
		this.action = action;
	}

	public static ChatAction fromString(final String string) {
		return Arrays.stream(values())
				.filter(chatAction -> chatAction.getAction().equals(string))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public String getAction() {
		return action;
	}
}
