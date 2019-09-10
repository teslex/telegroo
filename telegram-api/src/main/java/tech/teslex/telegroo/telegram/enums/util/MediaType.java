package tech.teslex.telegroo.telegram.enums.util;

public enum MediaType {

	PHOTO("photo"),
	AUDIO("audio"),
	DOCUMENT("document"),
	VIDEO("video"),
	ANIMATION("animation"),
	VOICE("voice"),
	VIDEO_NOTE("video_note"),
	STICKER("sticker");

	private String type;

	MediaType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
