package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendMediaGroup;

import java.util.Map;
import java.util.function.Consumer;

public interface SendMediaGroupMethod<R> {

	R sendMediaGroup(Map data);

	R sendMediaGroup(SendMediaGroup data);

	R sendMediaGroup(Consumer<SendMediaGroup.SendMediaGroupBuilder> data);
}
