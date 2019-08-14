package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.EditMessageLiveLocation;

import java.util.Map;
import java.util.function.Consumer;

public interface EditMessageLiveLocationMethod<R> {

	R editMessageLiveLocation(Map data);

	R editMessageLiveLocation(EditMessageLiveLocation data);

	R editMessageLiveLocation(Consumer<EditMessageLiveLocation> data);
}
