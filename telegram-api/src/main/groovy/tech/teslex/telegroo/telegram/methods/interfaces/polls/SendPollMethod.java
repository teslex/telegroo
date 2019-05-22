package tech.teslex.telegroo.telegram.methods.interfaces.polls;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.polls.SendPollMethodObject;

import java.util.Map;

public interface SendPollMethod<R> {

	R sendPoll(Map data);

	@NamedVariant
	R sendPoll(@NamedDelegate SendPollMethodObject data);

	R sendPoll(@DelegatesTo(value = SendPollMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
