package tech.teslex.telegroo.telegram.enums.util

import groovy.transform.CompileStatic

@CompileStatic
enum MediaType {

	PHOTO('photo'),
	AUDIO('audio'),
	DOCUMENT('document'),
	VIDEO('video'),
	ANIMATION('animation'),
	VOICE('voice'),
	VIDEO_NOTE('video_note'),
	STICKER('sticker')

	private String value

	String getValue() {
		return this.value
	}

	private MediaType(String value) {
		this.value = value
	}
}
