package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendDocumentMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendDocument;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendDocumentMethod extends SendDocumentMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendDocument(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendDocument(Consumer<SendDocument> data) {
		SendDocument method = SendDocument.create();
		data.accept(method);

		return sendDocument(method);
	}

	@Override
	default TelegramResult<Message> sendDocument(SendDocument data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
