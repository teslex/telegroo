package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.GetStickerSetMethodObject;

import java.util.Map;

public interface GetStickerSetMethod<R> {

	R getStickerSet(Map data);

	@NamedVariant
	R getStickerSet(@NamedDelegate GetStickerSetMethodObject data);

	R getStickerSet(@DelegatesTo(value = GetStickerSetMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
