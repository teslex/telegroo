package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SetChatStickerSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetChatStickerSetMethod extends SetChatStickerSetMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> setChatStickerSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> setChatStickerSet(Consumer<SetChatStickerSet> data) {
		SetChatStickerSet method = SetChatStickerSet.create();
		data.accept(method);

		return setChatStickerSet(method);
	}

	@Override
	default TelegramResult<Object> setChatStickerSet(SetChatStickerSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
