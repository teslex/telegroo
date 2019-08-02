package tech.teslex.telegroo.telegram.api.types.passport;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassportData {

	/**
	 * Array with information about documents and other Telegram Passport elements that was shared with the bot
	 */
	private List<EncryptedPassportElement> data;
	/**
	 * Encrypted credentials required to decrypt the data
	 */
	private EncryptedCredentials credentials;
}
