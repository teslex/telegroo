package tech.teslex.telegroo.api.req

class SomeAudio extends SomeFile {
	SomeAudio(File file, Map params = [:]) {
		super('sendAudio', 'audio', file, params)
	}
}
