package tech.teslex.telegroo.telegram.api.methods

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.api.types.input.InputMedia

@CompileStatic
interface MethodObjectWithMedia extends MethodObject {

	@JsonIgnore
	List<InputMedia> getMedia()
}