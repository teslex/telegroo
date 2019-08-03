package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.DeleteChatPhoto;

import java.util.Map;
import java.util.function.Consumer;

public interface DeleteChatPhotoMethod<R> {

	R deleteChatPhoto(Map data);

	R deleteChatPhoto(DeleteChatPhoto data);

	R deleteChatPhoto(Consumer<DeleteChatPhoto.DeleteChatPhotoBuilder> data);
}
