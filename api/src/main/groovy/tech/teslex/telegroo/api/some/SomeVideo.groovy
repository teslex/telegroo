package tech.teslex.telegroo.api.some

import groovy.transform.CompileStatic

@CompileStatic
class SomeVideo extends SomeFile {

	SomeVideo(File file, Map params) {
		super('sendVideo', 'video', file, params)
	}
}
