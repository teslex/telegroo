package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.AddStickerToSet;

import java.util.Map;
import java.util.function.Consumer;

public interface AddStickerToSetMethod<R> {

	R addStickerToSet(Map data);

	R addStickerToSet(AddStickerToSet data);

	R addStickerToSet(Consumer<AddStickerToSet> data);
}
