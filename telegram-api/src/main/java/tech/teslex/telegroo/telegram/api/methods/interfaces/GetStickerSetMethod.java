package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface GetStickerSetMethod<R> {

	R getStickerSet(Map data);

	R getStickerSet(GetStickerSet data);

	R getStickerSet(Consumer<GetStickerSet.GetStickerSetBuilder> data);
}
