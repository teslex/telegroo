package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendContactMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendContact;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendContactMethod extends SendContactMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendContact(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendContact(Consumer<SendContact> data) {
		SendContact method = SendContact.create();
		data.accept(method);

		return sendContact(method);
	}

	@Override
	default TelegramResult<Message> sendContact(SendContact data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
