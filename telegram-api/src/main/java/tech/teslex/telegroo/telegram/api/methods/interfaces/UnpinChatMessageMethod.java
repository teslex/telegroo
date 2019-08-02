package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.UnpinChatMessageMethodObject;

import java.util.Map;

public interface UnpinChatMessageMethod<R> {

	R unpinChatMessage(Map data);

	@NamedVariant
	R unpinChatMessage(@NamedDelegate UnpinChatMessageMethodObject data);

	R unpinChatMessage(@DelegatesTo(value = UnpinChatMessageMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
