package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendStickerMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendSticker;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendStickerMethod extends SendStickerMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendSticker(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendSticker(Consumer<SendSticker> data) {
		SendSticker method = SendSticker.create();
		data.accept(method);

		return sendSticker(method);
	}

	@Override
	default TelegramResult<Message> sendSticker(SendSticker data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
