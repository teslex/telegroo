package tech.teslex.telegroo.api.req

import groovy.transform.CompileStatic

@CompileStatic
class SomePhoto extends SomeFile {

	String caption

	SomePhoto(File file, Map params = [:]) {
		super('sendPhoto', 'photo', file, params)
	}

	SomePhoto(String caption, File file, Map params = [:]) {
		super('sendPhoto', 'photo', file, params + [caption: caption])
		this.caption = caption
	}
}
