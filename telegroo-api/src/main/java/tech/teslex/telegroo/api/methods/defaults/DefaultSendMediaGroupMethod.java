package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendMediaGroupMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendMediaGroup;
import tech.teslex.telegroo.telegram.api.types.Message;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendMediaGroupMethod extends SendMediaGroupMethod<TelegramResult<List<Message>>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<List<Message>> sendMediaGroup(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<List<Message>> sendMediaGroup(Consumer<SendMediaGroup> data) {
		SendMediaGroup method = SendMediaGroup.create();
		data.accept(method);

		return sendMediaGroup(method);
	}

	@Override
	default TelegramResult<List<Message>> sendMediaGroup(SendMediaGroup data) {
		final Context context = getContext();
		final Update currentUpdate = context.getCurrentUpdate();
		final TelegramClient telegramClient = context.getTelegramClient();

		data.useDefault(currentUpdate);

		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructParametricType(List.class, Message.class);

		return telegramClient.callWithMedia(data).asTelegramResult(type);
	}
}
