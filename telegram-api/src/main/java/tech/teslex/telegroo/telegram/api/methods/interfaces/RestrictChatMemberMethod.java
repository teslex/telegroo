package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.RestrictChatMemberMethodObject;

import java.util.Map;

public interface RestrictChatMemberMethod<R> {

	R restrictChatMember(Map data);

	@NamedVariant
	R restrictChatMember(@NamedDelegate RestrictChatMemberMethodObject data);

	R restrictChatMember(@DelegatesTo(value = RestrictChatMemberMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
