package tech.teslex.telegroo.simple.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
import groovy.transform.Immutable

@Immutable
@CompileStatic
@Newify([ObjectMapper, Jdk8Module])
final class JacksonObjectMapper {

	private static final ObjectMapper objectMapper = ObjectMapper().tap {
		registerModule Jdk8Module()
		configure SerializationFeature.FAIL_ON_EMPTY_BEANS, false
	}

	static ObjectMapper getObjectMapper() {
		objectMapper
	}
}