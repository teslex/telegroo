package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SetChatPhoto;

import java.util.Map;
import java.util.function.Consumer;

public interface SetChatPhotoMethod<R> {

	R setChatPhoto(Map data);

	R setChatPhoto(SetChatPhoto data);

	R setChatPhoto(Consumer<SetChatPhoto> data);
}
