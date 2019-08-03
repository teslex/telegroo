package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetUpdatesMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdates;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface DefaultDefaultGetUpdatesMethod extends GetUpdatesMethod<TelegramResult<List<Update>>> {

	/**
	 * @return update context
	 */
	Context getContext();

	@Override
	default TelegramResult<List<Update>> getUpdates(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<List<Update>> getUpdates(Consumer<GetUpdates.GetUpdatesBuilder> data) {
		GetUpdates.GetUpdatesBuilder builder = GetUpdates.builder();
		data.accept(builder);
		GetUpdates builtData = builder.build();

		return getUpdates(builtData);
	}

	@Override
	default TelegramResult<List<Update>> getUpdates(GetUpdates data) {
		JavaType type = JacksonObjectMapper
				.getObjectMapper()
				.getTypeFactory()
				.constructParametricType(
						TelegramResult.class,
						JacksonObjectMapper.getObjectMapper().getTypeFactory()
								.constructCollectionLikeType(ArrayList.class, Update.class)
				);

		return getContext().getTelegramClient().handleTelegramResponse(
				getContext().getTelegramClient().go(data), type);
	}
}
