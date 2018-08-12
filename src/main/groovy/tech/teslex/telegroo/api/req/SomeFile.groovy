package tech.teslex.telegroo.api.req

class SomeFile extends Some {
	String type
	File file

	SomeFile(String method, String type, File file, Map params = [:]) {
		super(method, params)
		this.type = type
		this.file = file
	}
}
