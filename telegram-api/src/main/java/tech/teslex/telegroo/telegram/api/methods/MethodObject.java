package tech.teslex.telegroo.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface MethodObject {

	@JsonIgnore
	String getPathMethod();
}
