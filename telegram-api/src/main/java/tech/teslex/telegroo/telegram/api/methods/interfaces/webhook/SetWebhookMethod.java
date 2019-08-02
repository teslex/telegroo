package tech.teslex.telegroo.telegram.api.methods.interfaces.webhook;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhookMethodObject;

import java.util.Map;

public interface SetWebhookMethod<R> {

	R setWebhook(Map data);

	@NamedVariant
	R setWebhook(@NamedDelegate SetWebhookMethodObject data);

	R setWebhook(@DelegatesTo(value = SetWebhookMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
