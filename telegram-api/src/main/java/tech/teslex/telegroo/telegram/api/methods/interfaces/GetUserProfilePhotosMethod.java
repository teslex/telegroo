package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetUserProfilePhotos;

import java.util.Map;
import java.util.function.Consumer;

public interface GetUserProfilePhotosMethod<R> {

	R getUserProfilePhotos(Map data);

	R getUserProfilePhotos(GetUserProfilePhotos data);

	R getUserProfilePhotos(Consumer<GetUserProfilePhotos.GetUserProfilePhotosBuilder> data);
}
