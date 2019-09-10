package tech.teslex.telegroo.api.methods.defaults.webhook;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.webhook.DeleteWebhookMethod;

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
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(() -> "deleteWebhook")
				.asTelegramResult(type);
	}
}
