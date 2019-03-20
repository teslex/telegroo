package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SendPhotoMethodObject;
import tech.teslex.telegroo.telegram.types.InputFile;

import java.util.Map;

public interface SendPhotoMethod<R> {

	R sendPhoto(Map data);

	R sendPhoto(InputFile photo);

	@NamedVariant
	R sendPhoto(@NamedDelegate SendPhotoMethodObject data);

	R sendPhoto(@DelegatesTo(SendPhotoMethodObject.class) Closure closure);
}
