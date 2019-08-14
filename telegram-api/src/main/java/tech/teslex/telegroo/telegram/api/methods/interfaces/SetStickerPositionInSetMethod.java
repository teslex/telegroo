package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SetStickerPositionInSet;

import java.util.Map;
import java.util.function.Consumer;

public interface SetStickerPositionInSetMethod<R> {

	R setStickerPositionInSet(Map data);

	R setStickerPositionInSet(SetStickerPositionInSet data);

	R setStickerPositionInSet(Consumer<SetStickerPositionInSet> data);
}
