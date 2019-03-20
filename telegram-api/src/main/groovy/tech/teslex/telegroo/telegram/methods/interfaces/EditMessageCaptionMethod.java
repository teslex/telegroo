package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.EditMessageCaptionMethodObject;

import java.util.Map;

public interface EditMessageCaptionMethod<R> {

	R editMessageCaption(Map data);

	@NamedVariant
	R editMessageCaption(@NamedDelegate EditMessageCaptionMethodObject data);

	R editMessageCaption(@DelegatesTo(EditMessageCaptionMethodObject.class) Closure closure);
}
