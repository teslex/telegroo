package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.EditMessageCaptionMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageCaption;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultEditMessageCaptionMethod extends EditMessageCaptionMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> editMessageCaption(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> editMessageCaption(Consumer<EditMessageCaption> data) {
		EditMessageCaption method = EditMessageCaption.create();
		data.accept(method);

		return editMessageCaption(method);
	}

	@Override
	default TelegramResult<Message> editMessageCaption(EditMessageCaption data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
