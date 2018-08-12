package tech.teslex.telegroo.api.req

import groovy.transform.CompileStatic

@CompileStatic
class SomeAudio extends SomeFile {
	SomeAudio(File file, Map params = [:]) {
		super('sendAudio', 'audio', file, params)
	}
}
