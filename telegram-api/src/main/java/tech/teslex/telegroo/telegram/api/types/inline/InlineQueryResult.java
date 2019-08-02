package tech.teslex.telegroo.telegram.api.types.inline;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * This object represents one result of an inline query. Telegram clients currently support results of the following 20 types:
 * <p>
 *
 * @see InlineQueryResultCachedAudio
 * @see InlineQueryResultCachedDocument
 * @see InlineQueryResultCachedGif
 * @see InlineQueryResultCachedMpeg4Gif
 * @see InlineQueryResultCachedPhoto
 * @see InlineQueryResultCachedSticker
 * @see InlineQueryResultCachedVideo
 * @see InlineQueryResultCachedVoice
 * @see InlineQueryResultArticle
 * @see InlineQueryResultAudio
 * @see InlineQueryResultContact
 * @see InlineQueryResultGame
 * @see InlineQueryResultDocument
 * @see InlineQueryResultGif
 * @see InlineQueryResultLocation
 * @see InlineQueryResultMpeg4Gif
 * @see InlineQueryResultPhoto
 * @see InlineQueryResultVenue
 * @see InlineQueryResultVideo
 * @see InlineQueryResultVoice
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class InlineQueryResult {
}
