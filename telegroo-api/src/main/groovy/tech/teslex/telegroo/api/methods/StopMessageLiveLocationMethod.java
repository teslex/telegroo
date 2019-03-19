package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.StopMessageLiveLocationMethodObject;

import java.util.Map;

public interface StopMessageLiveLocationMethod<R> {

	R stopMessageLiveLocation(Map data);

	@NamedVariant
	R stopMessageLiveLocation(@NamedDelegate StopMessageLiveLocationMethodObject data);

	R stopMessageLiveLocation(@DelegatesTo(StopMessageLiveLocationMethodObject.class) Closure closure);
}
