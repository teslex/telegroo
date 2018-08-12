package tech.teslex.telegroo.api.req

class SomeVoice extends SomeFile {
	SomeVoice(File file, Map params) {
		super('sendVoice', 'voice', file, params)
	}
}
