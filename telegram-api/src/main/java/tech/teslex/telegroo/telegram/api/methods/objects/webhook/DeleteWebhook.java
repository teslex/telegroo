package tech.teslex.telegroo.telegram.api.methods.objects.webhook;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * deleteWebhook
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns True on success. Requires no parameters.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteWebhook implements MethodObject {

	public static DeleteWebhook create() {
		return new DeleteWebhook();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "deleteWebhook";
	}

}
