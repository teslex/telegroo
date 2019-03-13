package tech.teslex.telegroo.telegram.enums

import groovy.transform.CompileStatic

@CompileStatic
enum ChatAction {

	TYPING('typing'),
	UPLOAD_PHOTO('upload_photo'),
	RECORD_VIDEO('record_video'),
	UPLOAD_VIDEO('upload_video'),
	RECORD_AUDIO('record_audio'),
	UPLOAD_AUDIO('upload_audio'),
	UPLOAD_DOCUMENT('upload_document'),
	FIND_LOCATION('find_location'),
	RECORD_VIDEO_NOTE('record_video_note'),
	UPLOAD_VIDEO_NOTE('upload_video_note')

	private String action

	String getAction() {
		this.action
	}

	private ChatAction(String action) {
		this.action = action
	}

	static ChatAction fromString(String string) {
		values().find { it.action == string }
	}
}
