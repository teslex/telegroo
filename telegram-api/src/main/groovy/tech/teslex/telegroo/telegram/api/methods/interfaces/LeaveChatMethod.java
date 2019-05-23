package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.LeaveChatMethodObject;

import java.util.Map;

public interface LeaveChatMethod<R> {

	R leaveChat(Map data);

	@NamedVariant
	R leaveChat(@NamedDelegate LeaveChatMethodObject data);

	R leaveChat(@DelegatesTo(value = LeaveChatMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
