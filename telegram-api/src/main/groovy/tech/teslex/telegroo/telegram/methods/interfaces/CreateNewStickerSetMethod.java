package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.CreateNewStickerSetMethodObject;

import java.util.Map;

public interface CreateNewStickerSetMethod<R> {

	R createNewStickerSet(Map data);

	@NamedVariant
	R createNewStickerSet(@NamedDelegate CreateNewStickerSetMethodObject data);

	R createNewStickerSet(@DelegatesTo(value = CreateNewStickerSetMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
