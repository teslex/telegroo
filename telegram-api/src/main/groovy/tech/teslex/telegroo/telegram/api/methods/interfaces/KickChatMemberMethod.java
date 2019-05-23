package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.KickChatMemberMethodObject;

import java.util.Map;

public interface KickChatMemberMethod<R> {

	R kickChatMember(Map data);

	@NamedVariant
	R kickChatMember(@NamedDelegate KickChatMemberMethodObject data);

	R kickChatMember(@DelegatesTo(value = KickChatMemberMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
