package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.UnpinChatMessageMethodObject;

import java.util.Map;

public interface UnpinChatMessageMethod<R> {

	R unpinChatMessage(Map data);

	@NamedVariant
	R unpinChatMessage(@NamedDelegate UnpinChatMessageMethodObject data);

	R unpinChatMessage(@DelegatesTo(UnpinChatMessageMethodObject.class) Closure closure);
}