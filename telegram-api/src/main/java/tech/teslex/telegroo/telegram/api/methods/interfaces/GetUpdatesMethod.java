package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetUpdates;

import java.util.Map;
import java.util.function.Consumer;

public interface GetUpdatesMethod<R> {

	R getUpdates(Map data);

	R getUpdates(GetUpdates data);

	R getUpdates(Consumer<GetUpdates.GetUpdatesBuilder> data);
}