package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendVideoNoteMethodObject;

import java.util.Map;

public interface SendVideoNoteMethod<R> {

	R sendVideoNote(Map data);

	@NamedVariant
	R sendVideoNote(@NamedDelegate SendVideoNoteMethodObject data);

	R sendVideoNote(@DelegatesTo(value = SendVideoNoteMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
