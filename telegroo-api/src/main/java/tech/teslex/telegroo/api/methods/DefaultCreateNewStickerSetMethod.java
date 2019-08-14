package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.CreateNewStickerSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.CreateNewStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultCreateNewStickerSetMethod extends CreateNewStickerSetMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> createNewStickerSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> createNewStickerSet(Consumer<CreateNewStickerSet> data) {
		CreateNewStickerSet method = CreateNewStickerSet.create();
		data.accept(method);

		return createNewStickerSet(method);
	}

	@Override
	default TelegramResult<Object> createNewStickerSet(CreateNewStickerSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
