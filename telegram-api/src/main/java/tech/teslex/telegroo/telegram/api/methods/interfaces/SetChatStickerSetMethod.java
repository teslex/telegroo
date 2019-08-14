package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SetChatStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface SetChatStickerSetMethod<R> {

	R setChatStickerSet(Map data);

	R setChatStickerSet(SetChatStickerSet data);

	R setChatStickerSet(Consumer<SetChatStickerSet> data);
}
