package tech.teslex.telegroo.telegram.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.attach.InputFile

@CompileStatic
interface MethodObjectWithFile extends MethodObject {

	@JsonIgnore
	InputFile getFile()
}