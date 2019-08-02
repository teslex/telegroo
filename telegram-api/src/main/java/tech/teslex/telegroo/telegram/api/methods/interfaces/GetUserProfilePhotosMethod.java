package tech.teslex.telegroo.telegram.api.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.GetUserProfilePhotosMethodObject;

import java.util.Map;

public interface GetUserProfilePhotosMethod<R> {

	R getUserProfilePhotos(Map data);

	@NamedVariant
	R getUserProfilePhotos(@NamedDelegate GetUserProfilePhotosMethodObject data);

	R getUserProfilePhotos(@DelegatesTo(value = GetUserProfilePhotosMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
