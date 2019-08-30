package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendMessageMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendMessage;
import tech.teslex.telegroo.telegram.api.types.Message;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendMessageMethod extends SendMessageMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendMessage(Map data) {
		throw new AssertionError("not implemented");
	}

	default TelegramResult<Message> sendMessage(String text) {
		return sendMessage(
				SendMessage
						.create()
						.text(text)
		);
	}

	@Override
	default TelegramResult<Message> sendMessage(Object chatId, String text) {
		return sendMessage(
				SendMessage
						.create()
						.chatId(chatId)
						.text(text)
		);
	}

	@Override
	default TelegramResult<Message> sendMessage(Consumer<SendMessage> data) {
		SendMessage method = SendMessage.create();
		data.accept(method);

		return sendMessage(method);
	}

	@Override
	default TelegramResult<Message> sendMessage(SendMessage data) {
		final Context context = getContext();
		final Update currentUpdate = context.getCurrentUpdate();
		final TelegramClient telegramClient = context.getTelegramClient();

		data.useDefault(currentUpdate);

		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return telegramClient.call(data).asTelegramResult(type);
	}
}
