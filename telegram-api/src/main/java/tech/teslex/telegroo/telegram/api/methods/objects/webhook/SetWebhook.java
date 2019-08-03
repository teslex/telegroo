package tech.teslex.telegroo.telegram.api.methods.objects.webhook;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.attach.InputFile;

import java.util.List;

/**
 * setWebhook
 * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized Update. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns True on success.
 * <p>
 * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g. https://www.example.com/<token>. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetWebhook implements MethodObject {

	/**
	 * HTTPS url to send updates to. Use an empty string to remove webhook integration
	 */
	@JsonProperty(required = true)
	private String url;

	/**
	 * Upload your public key certificate so that the root certificate in use can be checked. See our self-signed guide for details.
	 */
	@JsonProperty(required = false)
	private InputFile certificate;

	/**
	 * Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to 40. Use lower values to limit the load on your bot‘s server, and higher values to increase your bot’s throughput.
	 */
	@JsonProperty(value = "max_connections", required = false)
	private Integer maxConnections;

	/**
	 * List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list of available update types. Specify an empty list to receive all updates regardless of value (default). If not specified, the previous setting will be used.
	 */
	@JsonProperty(value = "allowed_updates", required = false)
	private List<String> allowedUpdates;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "setWebhook";
	}
}
