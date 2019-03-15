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
 * Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns True on success.
 *
 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.
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
