package tech.teslex.telegroo.api.req

import groovy.transform.CompileStatic

@CompileStatic
class SomeVoice extends SomeFile {
	SomeVoice(File file, Map params) {
		super('sendVoice', 'voice', file, params)
	}
}
