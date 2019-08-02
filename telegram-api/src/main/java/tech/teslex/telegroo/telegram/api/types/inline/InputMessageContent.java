package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * This object represents the content of a message to be sent as a result of an inline query. Telegram clients currently support the following 4 types:
 * <p>
 *
 * @see InputTextMessageContent
 * @see InputLocationMessageContent
 * @see InputVenueMessageContent
 * @see InputContactMessageContent
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class InputMessageContent {
}