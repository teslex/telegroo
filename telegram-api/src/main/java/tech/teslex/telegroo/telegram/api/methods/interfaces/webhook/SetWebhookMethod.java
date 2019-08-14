package tech.teslex.telegroo.telegram.api.methods.interfaces.webhook;

import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;

import java.util.Map;
import java.util.function.Consumer;

public interface SetWebhookMethod<R> {

	R setWebhook(Map data);

	R setWebhook(SetWebhook data);

	R setWebhook(Consumer<SetWebhook> data);
}
