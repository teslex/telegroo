package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.SetChatPhotoMethodObject;

import java.util.Map;

public interface SetChatPhotoMethod<R> {

	R setChatPhoto(Map data);

	@NamedVariant
	R setChatPhoto(@NamedDelegate SetChatPhotoMethodObject data);

	R setChatPhoto(@DelegatesTo(value = SetChatPhotoMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
