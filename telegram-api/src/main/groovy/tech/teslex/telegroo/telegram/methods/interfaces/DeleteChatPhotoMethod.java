package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatPhotoMethodObject;

import java.util.Map;

public interface DeleteChatPhotoMethod<R> {

	R deleteChatPhoto(Map data);

	@NamedVariant
	R deleteChatPhoto(@NamedDelegate DeleteChatPhotoMethodObject data);

	R deleteChatPhoto(@DelegatesTo(DeleteChatPhotoMethodObject.class) Closure closure);
}
