package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendStickerMethodObject;

import java.util.Map;

public interface SendStickerMethod<R> {

	R sendSticker(Map data);

	@NamedVariant
	R sendSticker(@NamedDelegate SendStickerMethodObject data);

	R sendSticker(@DelegatesTo(SendStickerMethodObject.class) Closure closure);
}
