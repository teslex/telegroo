package tech.teslex.telegroo.api.some

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
