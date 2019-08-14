package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.EditMessageMediaMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageMedia;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultEditMessageMediaMethod extends EditMessageMediaMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> editMessageMedia(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> editMessageMedia(Consumer<EditMessageMedia> data) {
		EditMessageMedia method = EditMessageMedia.create();
		data.accept(method);

		return editMessageMedia(method);
	}

	@Override
	default TelegramResult<Message> editMessageMedia(EditMessageMedia data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
