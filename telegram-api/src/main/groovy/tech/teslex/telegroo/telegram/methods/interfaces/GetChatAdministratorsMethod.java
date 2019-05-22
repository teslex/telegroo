package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.GetChatAdministratorsMethodObject;

import java.util.Map;

public interface GetChatAdministratorsMethod<R> {

	R getChatAdministrators(Map data);

	@NamedVariant
	R getChatAdministrators(@NamedDelegate GetChatAdministratorsMethodObject data);

	R getChatAdministrators(@DelegatesTo(value = GetChatAdministratorsMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
