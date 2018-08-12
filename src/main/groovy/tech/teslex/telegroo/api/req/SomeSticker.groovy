package tech.teslex.telegroo.api.req

import groovy.transform.CompileStatic

@CompileStatic
class SomeSticker extends SomeFile {

	SomeSticker(File file, Map params) {
		super('sendSticker', 'sticker', file, params)
	}
}
