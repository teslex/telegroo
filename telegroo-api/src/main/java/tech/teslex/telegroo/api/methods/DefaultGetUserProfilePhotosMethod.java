package tech.teslex.telegroo.api.methods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetUserProfilePhotosMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUserProfilePhotos;
import tech.teslex.telegroo.telegram.api.types.UserProfilePhotos;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetUserProfilePhotosMethod extends GetUserProfilePhotosMethod<TelegramResult<UserProfilePhotos>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<UserProfilePhotos> getUserProfilePhotos(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<UserProfilePhotos> getUserProfilePhotos(Consumer<GetUserProfilePhotos> data) {
		GetUserProfilePhotos method = GetUserProfilePhotos.create();
		data.accept(method);

		return getUserProfilePhotos(method);
	}

	@Override
	default TelegramResult<UserProfilePhotos> getUserProfilePhotos(GetUserProfilePhotos data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(UserProfilePhotos.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
