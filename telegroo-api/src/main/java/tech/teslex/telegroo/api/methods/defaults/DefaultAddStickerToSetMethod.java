package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.AddStickerToSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.AddStickerToSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultAddStickerToSetMethod extends AddStickerToSetMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> addStickerToSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> addStickerToSet(Consumer<AddStickerToSet> data) {
		AddStickerToSet method = AddStickerToSet.create();
		data.accept(method);

		return addStickerToSet(method);
	}

	@Override
	default TelegramResult<Object> addStickerToSet(AddStickerToSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
