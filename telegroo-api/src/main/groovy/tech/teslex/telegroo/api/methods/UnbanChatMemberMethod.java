package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.UnbanChatMemberMethodObject;

import java.util.Map;

public interface UnbanChatMemberMethod<R> {

	R unbanChatMember(Map data);

	@NamedVariant
	R unbanChatMember(@NamedDelegate UnbanChatMemberMethodObject data);

	R unbanChatMember(@DelegatesTo(UnbanChatMemberMethodObject.class) Closure closure);
}
