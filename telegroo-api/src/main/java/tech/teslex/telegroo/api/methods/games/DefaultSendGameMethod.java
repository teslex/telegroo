package tech.teslex.telegroo.api.methods.games;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.games.SendGameMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.games.SendGame;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendGameMethod extends SendGameMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendGame(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendGame(Consumer<SendGame> data) {
		SendGame method = SendGame.create();
		data.accept(method);

		return sendGame(method);
	}

	@Override
	default TelegramResult<Message> sendGame(SendGame data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
