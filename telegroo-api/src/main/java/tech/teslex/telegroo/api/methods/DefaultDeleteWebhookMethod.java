package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.webhook.DeleteWebhookMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.DeleteWebhook;

public interface DefaultDeleteWebhookMethod extends DeleteWebhookMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	@Override
	default TelegramResult<Object> deleteWebhook() {
		final Context context = getContext();
		final TelegramClient telegramClient = context.getTelegramClient();

		JavaType type = JacksonObjectMapper
				.getObjectMapper()
				.getTypeFactory()
				.constructParametricType(
						TelegramResult.class,
						Object.class
				);

		return telegramClient
				.handleTelegramResponse(telegramClient.go(new DeleteWebhook()), type);
	}
}
