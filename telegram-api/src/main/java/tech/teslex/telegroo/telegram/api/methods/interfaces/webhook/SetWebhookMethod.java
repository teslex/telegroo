package tech.teslex.telegroo.telegram.api.methods.interfaces.webhook;

import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.function.Consumer;

/**
 * setWebhook
 * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized Update. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns True on success.
 * <p>
 * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g. https://www.example.com/<token>. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
 */
public interface SetWebhookMethod<R> {

	R setWebhook(@NotEmpty Map data);

	R setWebhook(@NotNull SetWebhook data);

	R setWebhook(@NotNull Consumer<SetWebhook> data);

	R setWebhook(@NotBlank String url);
}
