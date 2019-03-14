package tech.teslex.telegroo.telegram.types.passport

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
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
