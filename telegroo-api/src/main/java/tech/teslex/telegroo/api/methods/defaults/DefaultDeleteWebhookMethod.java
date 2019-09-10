package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.webhook.DeleteWebhookMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.DeleteWebhook;

public interface DefaultDeleteWebhookMethod extends DeleteWebhookMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> deleteWebhook() {
		final Context context = getContext();
		final TelegramClient telegramClient = context.getTelegramClient();

		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructParametricType(
						TelegramResult.class,
						Object.class
				);

		return telegramClient.call(new DeleteWebhook()).asTelegramResult(type);
	}
}
