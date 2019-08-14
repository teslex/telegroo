package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.DeleteStickerFromSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.DeleteStickerFromSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultDeleteStickerFromSetMethod extends DeleteStickerFromSetMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> deleteStickerFromSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> deleteStickerFromSet(Consumer<DeleteStickerFromSet> data) {
		DeleteStickerFromSet method = DeleteStickerFromSet.create();
		data.accept(method);

		return deleteStickerFromSet(method);
	}

	@Override
	default TelegramResult<Object> deleteStickerFromSet(DeleteStickerFromSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
