package tech.teslex.telegroo.api.methods.payments;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.payments.SendInvoiceMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.payments.SendInvoice;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultSendInvoiceMethod extends SendInvoiceMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Message> sendInvoice(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Message> sendInvoice(Consumer<SendInvoice> data) {
		SendInvoice method = SendInvoice.create();
		data.accept(method);

		return sendInvoice(method);
	}

	@Override
	default TelegramResult<Message> sendInvoice(SendInvoice data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Message.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
