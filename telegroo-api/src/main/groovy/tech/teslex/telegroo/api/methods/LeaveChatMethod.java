package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.LeaveChatMethodObject;

import java.util.Map;

public interface LeaveChatMethod<R> {

	R leaveChat(Map data);

	@NamedVariant
	R leaveChat(@NamedDelegate LeaveChatMethodObject data);

	R leaveChat(@DelegatesTo(LeaveChatMethodObject.class) Closure closure);
}
