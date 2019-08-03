package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.DeleteChatStickerSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DeleteChatStickerSetMethod<R> {

	R deleteChatStickerSet(Map data);

	R deleteChatStickerSet(DeleteChatStickerSet data);

	R deleteChatStickerSet(Consumer<DeleteChatStickerSet.DeleteChatStickerSetBuilder> data);
}
