package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
import tech.teslex.telegroo.api.methods.next.ClassUtils;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.SendMessageMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.SendMessageMethodObject;
import tech.teslex.telegroo.telegram.api.types.Message;

import java.util.Map;

public interface DefaultSendMessageMethod extends SendMessageMethod<TelegramResult<Message>> {

	/**
	 * @return update context
	 */
	Context getContext();

	@Override
	default TelegramResult<Message> sendMessage(Map data) {
		throw new AssertionError("not implemented");
	}

	default TelegramResult<Message> sendMessage(String text) {
		return sendMessage(
				SendMessageMethodObject
						.builder()
						.text(text)
						.build()
		);
	}

	@Override
	default TelegramResult<Message> sendMessage(String text, Long chatId) {
		return sendMessage(
				SendMessageMethodObject
						.builder()
						.chatId(chatId)
						.text(text)
						.build()
		);
	}

	@Override
	default TelegramResult<Message> sendMessage(@DelegatesTo(value = SendMessageMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		return sendMessage(ClassUtils.delegate(SendMessageMethodObject.builder().build(), closure));
	}

	@Override
	@NamedVariant
	default TelegramResult<Message> sendMessage(@NamedDelegate SendMessageMethodObject data) {
		final var context = getContext();
		final var currentUpdate = context.getCurrentUpdate();
		final var telegramClient = context.getTelegramClient();

		if (data.getChatId() == null && currentUpdate != null && currentUpdate.getChatId() != null && currentUpdate.getChatId() != -1)
			data.setChatId(currentUpdate.getChatId());
		else
			throw new IllegalArgumentException("chat id is null");

		JavaType type = JacksonObjectMapper
				.getObjectMapper()
				.getTypeFactory()
				.constructParametricType(
						TelegramResult.class,
						Message.class
				);

		return telegramClient
				.handleTelegramResponse(telegramClient.go(data), type);
	}
}
