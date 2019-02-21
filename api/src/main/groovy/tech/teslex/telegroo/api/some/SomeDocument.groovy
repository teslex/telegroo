package tech.teslex.telegroo.api.some

import groovy.transform.CompileStatic

@CompileStatic
class SomeDocument extends SomeFile {

	SomeDocument(File document, Map params = [:]) {
		super('sendDocument', 'document', document, params)
	}
}
