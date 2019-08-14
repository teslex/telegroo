package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.webhook.SetWebhookMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetWebhookMethod extends SetWebhookMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> setWebhook(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> setWebhook(Consumer<SetWebhook> data) {
		SetWebhook method = SetWebhook.create();
		data.accept(method);

		return setWebhook(method);
	}

	@Override
	default TelegramResult<Object> setWebhook(SetWebhook data) {
		final Context context = getContext();
		final TelegramClient telegramClient = context.getTelegramClient();

		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return telegramClient
				.call(data)
				.asTelegramResult(type);
	}
}
