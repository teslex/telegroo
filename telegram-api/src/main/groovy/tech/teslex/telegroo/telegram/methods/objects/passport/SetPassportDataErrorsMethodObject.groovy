package tech.teslex.telegroo.telegram.methods.objects.passport

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.types.passport.error.PassportElementError

/**
 * setPassportDataErrors
 * description
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class SetPassportDataErrorsMethodObject implements MethodObject {

	/**
	 * User identifier
	 */
	@JsonProperty(value = 'user_id', required = true)
	Integer userId

	/**
	 * A JSON-serialized array describing the errors
	 */
	@JsonProperty(required = true)
	List<PassportElementError> errors

	@Override
	String getPathMethod() {
		'setPassportDataErrors'
	}
}
