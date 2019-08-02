package tech.teslex.telegroo.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tech.teslex.telegroo.telegram.api.types.input.InputMedia;

import java.util.List;

public interface MethodObjectWithMedia extends MethodObject {

	@JsonIgnore
	List<InputMedia> getMedia();
}
