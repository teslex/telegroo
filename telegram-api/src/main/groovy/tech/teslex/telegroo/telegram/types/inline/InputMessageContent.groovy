package tech.teslex.telegroo.telegram.types.inline

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.transform.ToString

/**
 * This object represents the content of a message to be sent as a result of an inline query. Telegram clients currently support the following 4 types:
 *
 * InputTextMessageContent
 * InputLocationMessageContent
 * InputVenueMessageContent
 * InputContactMessageContent
 */
@ToString
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
abstract class InputMessageContent {
}
