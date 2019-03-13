package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class Contact {

	/**
	 * Contact's phone number
	 */
	@JsonProperty(value = 'phone_number')
	String phoneNumber

	/**
	 * Contact's first name
	 */
	@JsonProperty(value = 'first_name')
	String firstName

	/**
	 * Optional. Contact's last name
	 */
	@JsonProperty(value = 'last_name', required = false)
	String lastName

	/**
	 * Optional. Contact's user identifier in Telegram
	 */
	@JsonProperty(value = 'user_id', required = false)
	Integer userId

	/**
	 * Optional. Additional data about the contact in the form of a vCard
	 */
	@JsonProperty(required = false)
	String vcard
}
