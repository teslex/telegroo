package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SetStickerPositionInSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SetStickerPositionInSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetStickerPositionInSetMethod extends SetStickerPositionInSetMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> setStickerPositionInSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> setStickerPositionInSet(Consumer<SetStickerPositionInSet> data) {
		SetStickerPositionInSet method = SetStickerPositionInSet.create();
		data.accept(method);

		return setStickerPositionInSet(method);
	}

	@Override
	default TelegramResult<Object> setStickerPositionInSet(SetStickerPositionInSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
