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
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetUpdatesMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdatesMethodObject;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	default TelegramResult<List<Update>> getUpdates(@DelegatesTo(value = GetUpdatesMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		return getUpdates(ClassUtils.delegate(GetUpdatesMethodObject.builder().build(), closure));
	}

	@Override
	@NamedVariant
	default TelegramResult<List<Update>> getUpdates(@NamedDelegate GetUpdatesMethodObject data) {
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
