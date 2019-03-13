package tech.teslex.telegroo.telegram.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.types.InputMedia

@CompileStatic
interface MethodObjectWithMedia extends MethodObject {

	@JsonIgnore
	List<InputMedia> getMedia()
}