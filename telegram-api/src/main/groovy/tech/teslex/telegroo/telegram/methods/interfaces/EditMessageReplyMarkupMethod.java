package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.EditMessageReplyMarkupMethodObject;

import java.util.Map;

public interface EditMessageReplyMarkupMethod<R> {

	R editMessageReplyMarkup(Map data);

	@NamedVariant
	R editMessageReplyMarkup(@NamedDelegate EditMessageReplyMarkupMethodObject data);

	R editMessageReplyMarkup(@DelegatesTo(EditMessageReplyMarkupMethodObject.class) Closure closure);
}
