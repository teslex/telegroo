package tech.teslex.telegroo.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tech.teslex.telegroo.telegram.attach.InputFile;

public interface MethodObjectWithFile extends MethodObject {

	@JsonIgnore
	InputFile getInputFile();
}
