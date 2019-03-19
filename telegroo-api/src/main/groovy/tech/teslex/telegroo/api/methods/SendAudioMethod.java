package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendAudioMethodObject;

import java.util.Map;

public interface SendAudioMethod<R> {

	R sendAudio(Map data);

	@NamedVariant
	R sendAudio(@NamedDelegate SendAudioMethodObject data);

	R sendAudio(@DelegatesTo(SendAudioMethodObject.class) Closure closure);
}
