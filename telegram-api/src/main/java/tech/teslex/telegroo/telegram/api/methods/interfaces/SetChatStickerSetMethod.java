package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatStickerSetMethodObject;

import java.util.Map;

public interface SetChatStickerSetMethod<R> {

	R setChatStickerSet(Map data);

	@NamedVariant
	R setChatStickerSet(@NamedDelegate SetChatStickerSetMethodObject data);

	R setChatStickerSet(@DelegatesTo(value = SetChatStickerSetMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
