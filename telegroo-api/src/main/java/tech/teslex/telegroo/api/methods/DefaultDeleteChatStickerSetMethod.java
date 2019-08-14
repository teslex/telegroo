package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.DeleteChatStickerSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.DeleteChatStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultDeleteChatStickerSetMethod extends DeleteChatStickerSetMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> deleteChatStickerSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> deleteChatStickerSet(Consumer<DeleteChatStickerSet> data) {
		DeleteChatStickerSet method = DeleteChatStickerSet.create();
		data.accept(method);

		return deleteChatStickerSet(method);
	}

	@Override
	default TelegramResult<Object> deleteChatStickerSet(DeleteChatStickerSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
