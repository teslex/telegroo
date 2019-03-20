package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SetChatStickerSetMethodObject;

import java.util.Map;

public interface SetChatStickerSetMethod<R> {

	R setChatStickerSet(Map data);

	@NamedVariant
	R setChatStickerSet(@NamedDelegate SetChatStickerSetMethodObject data);

	R setChatStickerSet(@DelegatesTo(SetChatStickerSetMethodObject.class) Closure closure);
}
