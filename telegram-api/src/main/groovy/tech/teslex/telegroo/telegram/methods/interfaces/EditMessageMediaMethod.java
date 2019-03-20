package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.EditMessageMediaMethodObject;

import java.util.Map;

public interface EditMessageMediaMethod<R> {

	R editMessageMedia(Map data);

	@NamedVariant
	R editMessageMedia(@NamedDelegate EditMessageMediaMethodObject data);

	R editMessageMedia(@DelegatesTo(EditMessageMediaMethodObject.class) Closure closure);
}
