package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.CreateNewStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface CreateNewStickerSetMethod<R> {

	R createNewStickerSet(Map data);

	R createNewStickerSet(CreateNewStickerSet data);

	R createNewStickerSet(Consumer<CreateNewStickerSet.CreateNewStickerSetBuilder> data);
}
