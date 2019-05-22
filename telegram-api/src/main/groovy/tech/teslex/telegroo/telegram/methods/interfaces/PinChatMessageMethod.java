package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.PinChatMessageMethodObject;

import java.util.Map;

public interface PinChatMessageMethod<R> {

	R pinChatMessage(Map data);

	@NamedVariant
	R pinChatMessage(@NamedDelegate PinChatMessageMethodObject data);

	R pinChatMessage(@DelegatesTo(value = PinChatMessageMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
