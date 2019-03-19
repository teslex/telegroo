package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.GetChatMethodObject;

import java.util.Map;

public interface GetChatMethod<R> {

	R getChat(Map data);

	@NamedVariant
	R getChat(@NamedDelegate GetChatMethodObject data);

	R getChat(@DelegatesTo(GetChatMethodObject.class) Closure closure);
}
