package tech.teslex.telegroo.telegram.types.passport

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.transform.Canonical

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class EncryptedCredentials {

	/**
	 * Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for EncryptedPassportElement decryption and authentication
	 */
	String data

	/**
	 * Base64-encoded data hash for data authentication
	 */
	String hash

	/**
	 * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
	 */
	String secret
}