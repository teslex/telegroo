package tech.teslex.telegroo.telegram.api.methods.objects.passport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.types.passport.error.PassportElementError;

import java.util.List;

/**
 * setPassportDataErrors
 * Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns True on success.
 * <p>
 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetPassportDataErrors implements MethodObject {

	/**
	 * User identifier
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * A JSON-serialized array describing the errors
	 */
	@JsonProperty(required = true)
	private List<PassportElementError> errors;

	@Override
	public String getPathMethod() {
		return "setPassportDataErrors";
	}
}
