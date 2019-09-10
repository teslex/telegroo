package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.GetStickerSetMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.GetStickerSet;
import tech.teslex.telegroo.telegram.api.types.stickers.StickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultGetStickerSetMethod extends GetStickerSetMethod<TelegramResult<StickerSet>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<StickerSet> getStickerSet(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<StickerSet> getStickerSet(Consumer<GetStickerSet> data) {
		GetStickerSet method = GetStickerSet.create();
		data.accept(method);

		return getStickerSet(method);
	}

	@Override
	default TelegramResult<StickerSet> getStickerSet(GetStickerSet data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(StickerSet.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
