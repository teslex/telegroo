package tech.teslex.telegroo.api.methods.reply;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;

public interface ReplyMethod {

	void reply(Object replyTo, Closure closure);

	void reply(@DelegatesTo(MethodsContext.class) Closure closure);

	MethodsContext reply(Object replyTo);

	MethodsContext reply();
}