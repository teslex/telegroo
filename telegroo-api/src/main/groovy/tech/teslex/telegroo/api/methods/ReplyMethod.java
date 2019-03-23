package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import tech.teslex.telegroo.api.context.MethodsContext;

public interface ReplyMethod {

	void reply(Object replyTo, Closure closure);

	void reply(Closure closure);

	MethodsContext reply(Object replyTo);

	MethodsContext reply();
}
