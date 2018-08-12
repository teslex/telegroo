package tech.teslex.telegroo.api.req

import groovy.transform.CompileStatic

@CompileStatic
class Some {
	String method
	Map params

	Some(String method, Map params = [:]) {
		this.method = method
		this.params = params
	}
}
