package tech.teslex.telegroo.telegram.enums.util

import groovy.transform.CompileStatic

@CompileStatic
enum FileTypeMethodWithFile {

	PHOTO('photo'),
	AUDIO('audio'),
	DOCUMENT('document'),
	VIDEO('video'),
	ANIMATION('animation'),
	VOICE('voice'),
	VIDEO_NOTE('video_note')

	private String value

	String getValue() {
		return this.value
	}

	private FileTypeMethodWithFile(String value) {
		this.value = value
	}
}
