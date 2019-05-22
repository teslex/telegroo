package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.GetChatMembersCountMethodObject;

import java.util.Map;

public interface GetChatMembersCountMethod<R> {

	R getChatMembersCount(Map data);

	@NamedVariant
	R getChatMembersCount(@NamedDelegate GetChatMembersCountMethodObject data);

	R getChatMembersCount(@DelegatesTo(value = GetChatMembersCountMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
