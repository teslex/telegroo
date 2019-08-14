package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.DeleteStickerFromSet;

import java.util.Map;
import java.util.function.Consumer;

public interface DeleteStickerFromSetMethod<R> {

	R deleteStickerFromSet(Map data);

	R deleteStickerFromSet(DeleteStickerFromSet data);

	R deleteStickerFromSet(Consumer<DeleteStickerFromSet> data);
}
