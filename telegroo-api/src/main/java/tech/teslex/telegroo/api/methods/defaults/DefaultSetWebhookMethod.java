package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.webhook.SetWebhookMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetWebhookMethod extends SetWebhookMethod<TelegramResult<Boolean>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Boolean> setWebhook(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Boolean> setWebhook(Consumer<SetWebhook> data) {
		SetWebhook method = SetWebhook.create();
		data.accept(method);

		return setWebhook(method);
	}

	@Override
	default TelegramResult<Boolean> setWebhook(SetWebhook data) {
		final Context context = getContext();
		final TelegramClient telegramClient = context.getTelegramClient();

		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Boolean.class);

		return telegramClient
				.call(data)
				.asTelegramResult(type);
	}

	@Override
	default TelegramResult<Boolean> setWebhook(String url) {
		return setWebhook(SetWebhook.create().url(url));
	}
}
