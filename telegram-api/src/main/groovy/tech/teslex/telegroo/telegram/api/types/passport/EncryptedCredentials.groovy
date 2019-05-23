package tech.teslex.telegroo.telegram.api.types.passport


import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
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