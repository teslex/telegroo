package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SetChatDescriptionMethodObject;

import java.util.Map;

public interface SetChatDescriptionMethod<R> {

	R setChatDescription(Map data);

	@NamedVariant
	R setChatDescription(@NamedDelegate SetChatDescriptionMethodObject data);

	R setChatDescription(@DelegatesTo(SetChatDescriptionMethodObject.class) Closure closure);
}
