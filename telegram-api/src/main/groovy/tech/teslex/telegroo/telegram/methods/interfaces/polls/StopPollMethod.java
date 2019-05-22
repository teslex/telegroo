package tech.teslex.telegroo.telegram.methods.interfaces.polls;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.polls.StopPollMethodObject;

import java.util.Map;

public interface StopPollMethod<R> {

	R stopPoll(Map data);

	@NamedVariant
	R stopPoll(@NamedDelegate StopPollMethodObject data);

	R stopPoll(@DelegatesTo(value = StopPollMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
