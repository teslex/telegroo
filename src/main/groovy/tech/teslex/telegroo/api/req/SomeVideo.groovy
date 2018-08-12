package tech.teslex.telegroo.api.req

class SomeVideo extends SomeFile {
	SomeVideo(File file, Map params) {
		super('sendVideo', 'video', file, params)
	}
}
