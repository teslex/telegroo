package tech.teslex.telegroo.api.methods;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.SetChatPhotoMethodObject;

import java.util.Map;

public interface SetChatPhotoMethod<R> {

	R setChatPhoto(Map data);

	@NamedVariant
	R setChatPhoto(@NamedDelegate SetChatPhotoMethodObject data);

	R setChatPhoto(@DelegatesTo(SetChatPhotoMethodObject.class) Closure closure);
}
