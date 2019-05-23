package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatDescriptionMethodObject;

import java.util.Map;

public interface SetChatDescriptionMethod<R> {

	R setChatDescription(Map data);

	@NamedVariant
	R setChatDescription(@NamedDelegate SetChatDescriptionMethodObject data);

	R setChatDescription(@DelegatesTo(value = SetChatDescriptionMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
