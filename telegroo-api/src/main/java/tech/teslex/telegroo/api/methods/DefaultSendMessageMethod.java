package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
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

	@Override
	default TelegramResult<Message> sendMessage(Map data) {
		throw new AssertionError("not implemented");
	}

	default TelegramResult<Message> sendMessage(String text) {
		return sendMessage(
				SendMessage
						.builder()
						.text(text)
						.build()
		);
	}

	@Override
	default TelegramResult<Message> sendMessage(Long chatId, String text) {
		return sendMessage(
				SendMessage
						.builder()
						.chatId(chatId)
						.text(text)
						.build()
		);
	}

	@Override
	default TelegramResult<Message> sendMessage(Consumer<SendMessage.SendMessageBuilder> data) {
		SendMessage.SendMessageBuilder builder = SendMessage.builder();
		data.accept(builder);
		SendMessage builtData = builder.build();

		return sendMessage(builtData);
	}

	@Override
	default TelegramResult<Message> sendMessage(SendMessage data) {
		final Context context = getContext();
		final Update currentUpdate = context.getCurrentUpdate();
		final TelegramClient telegramClient = context.getTelegramClient();

		if (data.getChatId() == null && currentUpdate != null && currentUpdate.getChatId() != null && currentUpdate.getChatId() != -1)
			data.setChatId(currentUpdate.getChatId());
		else
			throw new IllegalArgumentException("chat id is null");

		JavaType type = JacksonObjectMapper
				.getObjectMapper()
				.getTypeFactory()
				.constructParametricType(
						TelegramResult.class,
						Message.class
				);

		return telegramClient
				.handleTelegramResponse(telegramClient.go(data), type);
	}
}
