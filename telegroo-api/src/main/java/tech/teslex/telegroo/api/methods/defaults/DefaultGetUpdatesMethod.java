package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetUpdatesMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdates;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetUpdatesMethod extends GetUpdatesMethod<TelegramResult<List<Update>>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<List<Update>> getUpdates(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<List<Update>> getUpdates(Consumer<GetUpdates> data) {
		GetUpdates method = GetUpdates.create();
		data.accept(method);

		return getUpdates(method);
	}

	@Override
	default TelegramResult<List<Update>> getUpdates(GetUpdates data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructCollectionType(ArrayList.class, Update.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
