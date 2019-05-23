package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageMediaMethodObject;

import java.util.Map;

public interface EditMessageMediaMethod<R> {

	R editMessageMedia(Map data);

	@NamedVariant
	R editMessageMedia(@NamedDelegate EditMessageMediaMethodObject data);

	R editMessageMedia(@DelegatesTo(value = EditMessageMediaMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
