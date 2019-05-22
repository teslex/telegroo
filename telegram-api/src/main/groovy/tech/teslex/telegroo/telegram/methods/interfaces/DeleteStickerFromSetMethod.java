package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.DeleteStickerFromSetMethodObject;

import java.util.Map;

public interface DeleteStickerFromSetMethod<R> {

	R deleteStickerFromSet(Map data);

	@NamedVariant
	R deleteStickerFromSet(@NamedDelegate DeleteStickerFromSetMethodObject data);

	R deleteStickerFromSet(@DelegatesTo(value = DeleteStickerFromSetMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
