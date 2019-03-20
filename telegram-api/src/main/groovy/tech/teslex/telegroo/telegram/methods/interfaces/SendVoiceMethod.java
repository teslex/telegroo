package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendVoiceMethodObject;

import java.util.Map;

public interface SendVoiceMethod<R> {

	R sendVoice(Map data);

	@NamedVariant
	R sendVoice(@NamedDelegate SendVoiceMethodObject data);

	R sendVoice(@DelegatesTo(SendVoiceMethodObject.class) Closure closure);
}
