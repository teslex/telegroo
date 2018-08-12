package tech.teslex.telegroo.api.req

class SomeVideoNote extends SomeFile {
	SomeVideoNote(File file, Map params) {
		super('sendVideoNote', 'video', file, params)
	}
}
