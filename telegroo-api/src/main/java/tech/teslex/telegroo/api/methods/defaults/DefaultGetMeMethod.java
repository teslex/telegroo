package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetMeMethod;
import tech.teslex.telegroo.telegram.api.types.User;

public interface DefaultGetMeMethod extends GetMeMethod<TelegramResult<User>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<User> getMe() {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(User.class);

		return getContext()
				.getTelegramClient()
				.call(() -> "getMe")
				.asTelegramResult(type);
	}
}
