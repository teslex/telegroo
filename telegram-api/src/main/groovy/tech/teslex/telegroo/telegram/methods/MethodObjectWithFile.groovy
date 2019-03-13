package tech.teslex.telegroo.telegram.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.enums.util.FileTypeMethodWithFile
import tech.teslex.telegroo.telegram.types.InputFile

@CompileStatic
interface MethodObjectWithFile extends MethodObject {

	@JsonIgnore
	<T> InputFile<T> getFile() // String or File

	@JsonIgnore
	FileTypeMethodWithFile getFileType()
}
