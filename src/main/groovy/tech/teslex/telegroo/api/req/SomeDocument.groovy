package tech.teslex.telegroo.api.req

class SomeDocument extends SomeFile {
	SomeDocument(File document, Map params = [:]) {
		super('sendDocument', 'document', document, params)
	}
}
