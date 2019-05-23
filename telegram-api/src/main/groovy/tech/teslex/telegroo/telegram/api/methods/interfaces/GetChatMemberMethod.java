package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.GetChatMemberMethodObject;

import java.util.Map;

public interface GetChatMemberMethod<R> {

	R getChatMember(Map data);

	@NamedVariant
	R getChatMember(@NamedDelegate GetChatMemberMethodObject data);

	R getChatMember(@DelegatesTo(value = GetChatMemberMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
