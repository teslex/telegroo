package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.RestrictChatMemberMethodObject;

import java.util.Map;

public interface RestrictChatMemberMethod<R> {

	R restrictChatMember(Map data);

	@NamedVariant
	R restrictChatMember(@NamedDelegate RestrictChatMemberMethodObject data);

	R restrictChatMember(@DelegatesTo(RestrictChatMemberMethodObject.class) Closure closure);
}
