package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SetChatPhotoMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatPhoto;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSetChatPhotoMethod extends SetChatPhotoMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> setChatPhoto(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> setChatPhoto(Consumer<SetChatPhoto> data) {
		SetChatPhoto method = SetChatPhoto.create();
		data.accept(method);

		return setChatPhoto(method);
	}

	@Override
	default TelegramResult<Object> setChatPhoto(SetChatPhoto data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
