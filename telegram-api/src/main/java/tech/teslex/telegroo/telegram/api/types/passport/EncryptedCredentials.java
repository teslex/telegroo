package tech.teslex.telegroo.telegram.api.types.passport;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EncryptedCredentials {

	/**
	 * Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for EncryptedPassportElement decryption and authentication
	 */
	private String data;
	/**
	 * Base64-encoded data hash for data authentication
	 */
	private String hash;
	/**
	 * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
	 */
	private String secret;
}
