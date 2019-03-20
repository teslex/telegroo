package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.PromoteChatMemberMethodObject;

import java.util.Map;

public interface PromoteChatMemberMethod<R> {

	R promoteChatMember(Map data);

	@NamedVariant
	R promoteChatMember(@NamedDelegate PromoteChatMemberMethodObject data);

	R promoteChatMember(@DelegatesTo(PromoteChatMemberMethodObject.class) Closure closure);
}
