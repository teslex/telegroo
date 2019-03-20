package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.AddStickerToSetMethodObject;

import java.util.Map;

public interface AddStickerToSetMethod<R> {

	R addStickerToSet(Map data);

	@NamedVariant
	R addStickerToSet(@NamedDelegate AddStickerToSetMethodObject data);

	R addStickerToSet(@DelegatesTo(AddStickerToSetMethodObject.class) Closure closure);
}
