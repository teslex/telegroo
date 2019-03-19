package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.GetFileMethodObject;

import java.util.Map;

public interface GetFileMethod<R> {

	R getFile(Map data);

	@NamedVariant
	R getFile(@NamedDelegate GetFileMethodObject data);

	R getFile(@DelegatesTo(GetFileMethodObject.class) Closure closure);
}
