package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendPhotoMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendPhoto;
import tech.teslex.telegroo.telegram.api.types.Message;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendPhotoMethod extends SendPhotoMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendPhoto(Map data) {
		throw new AssertionError("not implemented");
	}

	default TelegramResult<Message> sendPhoto(Consumer<SendPhoto> data) {
		SendPhoto method = SendPhoto.create();
		data.accept(method);

		return sendPhoto(method);
	}

	default TelegramResult<Message> sendPhoto(SendPhoto data) {
		final Context context = getContext();
		final Update currentUpdate = context.getCurrentUpdate();
		final TelegramClient telegramClient = context.getTelegramClient();

		if (data.getChatId() == null && currentUpdate != null && currentUpdate.getChatId() != null && currentUpdate.getChatId() != -1)
			data.setChatId(currentUpdate.getChatId());
		else
			throw new IllegalArgumentException("chat id cannot be null");

		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return telegramClient.callWithFile(data).asTelegramResult(type);
	}
}
