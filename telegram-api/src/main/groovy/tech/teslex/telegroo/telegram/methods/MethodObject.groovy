package tech.teslex.telegroo.telegram.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic

@CompileStatic
interface MethodObject {

	@JsonIgnore
	String getPathMethod()
}