package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.DeleteChatPhotoMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.DeleteChatPhoto;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultDeleteChatPhotoMethod extends DeleteChatPhotoMethod<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> deleteChatPhoto(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> deleteChatPhoto(Consumer<DeleteChatPhoto> data) {
		DeleteChatPhoto method = DeleteChatPhoto.create();
		data.accept(method);

		return deleteChatPhoto(method);
	}

	@Override
	default TelegramResult<Object> deleteChatPhoto(DeleteChatPhoto data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
