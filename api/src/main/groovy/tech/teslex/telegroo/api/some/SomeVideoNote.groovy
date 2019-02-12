package tech.teslex.telegroo.api.some

import groovy.transform.CompileStatic

@CompileStatic
class SomeVideoNote extends SomeFile {

	SomeVideoNote(File file, Map params) {
		super('sendVideoNote', 'video', file, params)
	}
}
