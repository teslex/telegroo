package tech.teslex.telegroo.telegram.api.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic

@CompileStatic
interface MethodObject {

	@JsonIgnore
	String getPathMethod()
}