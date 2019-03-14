package tech.teslex.telegroo.telegram.methods.objects.payments

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import groovy.transform.builder.Builder
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.types.payments.ShippingOption

/**
 * answerShippingQuery
 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified, the Bot API will send an Update with a shipping_query field to the bot. Use this method to reply to shipping queries. On success, True is returned.
 */
@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
@Builder
class AnswerShippingQueryMethodObject implements MethodObject {

	/**
	 * Unique identifier for the query to be answered
	 */
	@JsonProperty(value = 'shipping_query_id', required = true)
	String shippingQueryId

	/**
	 * Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
	 */
	@JsonProperty(required = true)
	Boolean ok

	/**
	 * Required if ok is True. A JSON-serialized array of available shipping options.
	 */
	@JsonProperty(value = 'shipping_options', required = false)
	List<ShippingOption> shippingOptions

	/**
	 * Required if ok is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
	 */
	@JsonProperty(value = 'error_message', required = false)
	String errorMessage

	@Override
	String getPathMethod() {
		'answerShippingQuery'
	}
}
