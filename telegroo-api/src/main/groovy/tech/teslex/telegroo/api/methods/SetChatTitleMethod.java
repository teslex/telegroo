package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SetChatTitleMethodObject;

import java.util.Map;

public interface SetChatTitleMethod<R> {

	R setChatTitle(Map data);

	@NamedVariant
	R setChatTitle(@NamedDelegate SetChatTitleMethodObject data);

	R setChatTitle(@DelegatesTo(SetChatTitleMethodObject.class) Closure closure);
}
