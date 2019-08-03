package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.webhook.SetWebhookMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetWebhookMethod extends SetWebhookMethod<Object> {

	/**
	 * @return update context
	 */
	Context getContext();

	@Override
	default Object setWebhook(Map data) {
		throw new AssertionError();
	}

	@Override
	default Object setWebhook(Consumer<SetWebhook.SetWebhookBuilder> data) {
		SetWebhook.SetWebhookBuilder builder = SetWebhook.builder();
		data.accept(builder);
		SetWebhook builtData = builder.build();

		return setWebhook(builtData);
	}

	@Override
	default Object setWebhook(SetWebhook data) {
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
				.handleTelegramResponse(telegramClient.go(data), type);
	}
}
