package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendSticker;

import java.util.Map;
import java.util.function.Consumer;

public interface SendStickerMethod<R> {

	R sendSticker(Map data);

	R sendSticker(SendSticker data);

	R sendSticker(Consumer<SendSticker.SendStickerBuilder> data);
}
