package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.UploadStickerFileMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.UploadStickerFile;
import tech.teslex.telegroo.telegram.api.types.FileObject;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultUploadStickerFileMethod extends UploadStickerFileMethod<TelegramResult<FileObject>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<FileObject> uploadStickerFile(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<FileObject> uploadStickerFile(Consumer<UploadStickerFile> data) {
		UploadStickerFile method = UploadStickerFile.create();
		data.accept(method);

		return uploadStickerFile(method);
	}

	@Override
	default TelegramResult<FileObject> uploadStickerFile(UploadStickerFile data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(FileObject.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
