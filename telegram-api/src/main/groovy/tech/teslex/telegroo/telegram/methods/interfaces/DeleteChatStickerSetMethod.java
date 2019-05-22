package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatStickerSetMethodObject;

import java.util.Map;

public interface DeleteChatStickerSetMethod<R> {

	R deleteChatStickerSet(Map data);

	@NamedVariant
	R deleteChatStickerSet(@NamedDelegate DeleteChatStickerSetMethodObject data);

	R deleteChatStickerSet(@DelegatesTo(value = DeleteChatStickerSetMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
