package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SetStickerPositionInSetMethodObject;

import java.util.Map;

public interface SetStickerPositionInSetMethod<R> {

	R setStickerPositionInSet(Map data);

	@NamedVariant
	R setStickerPositionInSet(@NamedDelegate SetStickerPositionInSetMethodObject data);

	R setStickerPositionInSet(@DelegatesTo(SetStickerPositionInSetMethodObject.class) Closure closure);
}
