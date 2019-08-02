package tech.teslex.telegroo.telegram.api.methods.objects.webhook;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * deleteWebhook
 * Use this method to get current webhook status. Requires no parameters. On success, returns a WebhookInfo object. If the bot is using getUpdates, will return an object with the url field empty.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetWebhookInfoMethodObject implements MethodObject {

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getWebhookInfo";
	}
}
