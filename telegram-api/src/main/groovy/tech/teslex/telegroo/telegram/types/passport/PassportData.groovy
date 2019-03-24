package tech.teslex.telegroo.telegram.types.passport


import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class PassportData {

	/**
	 * Array with information about documents and other Telegram Passport elements that was shared with the bot
	 */
	List<EncryptedPassportElement> data

	/**
	 * Encrypted credentials required to decrypt the data
	 */
	EncryptedCredentials credentials
}
