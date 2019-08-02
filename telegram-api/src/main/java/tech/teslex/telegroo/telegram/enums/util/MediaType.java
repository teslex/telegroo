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

	private String value;

	MediaType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
