package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendChatActionMethodObject;

import java.util.Map;

public interface SendChatActionMethod<R> {

	R sendChatAction(Map data);

	@NamedVariant
	R sendChatAction(@NamedDelegate SendChatActionMethodObject data);

	R sendChatAction(@DelegatesTo(value = SendChatActionMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
