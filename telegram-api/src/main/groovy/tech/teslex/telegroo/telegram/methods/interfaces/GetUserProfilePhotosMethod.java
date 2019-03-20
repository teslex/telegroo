package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.GetUserProfilePhotosMethodObject;

import java.util.Map;

public interface GetUserProfilePhotosMethod<R> {

	R getUserProfilePhotos(Map data);

	@NamedVariant
	R getUserProfilePhotos(@NamedDelegate GetUserProfilePhotosMethodObject data);

	R getUserProfilePhotos(@DelegatesTo(GetUserProfilePhotosMethodObject.class) Closure closure);
}
