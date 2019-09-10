package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetFileMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetFile;
import tech.teslex.telegroo.telegram.api.types.FileObject;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetFileMethod extends GetFileMethod<TelegramResult<FileObject>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<FileObject> getFile(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<FileObject> getFile(Consumer<GetFile> data) {
		GetFile method = GetFile.create();
		data.accept(method);

		return getFile(method);
	}

	@Override
	default TelegramResult<FileObject> getFile(GetFile data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(FileObject.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
