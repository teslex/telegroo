package tech.teslex.telegroo.api.req

class Some {
	String method
	Map params

	Some(String method, Map params = [:]) {
		this.method = method
		this.params = params
	}
}
