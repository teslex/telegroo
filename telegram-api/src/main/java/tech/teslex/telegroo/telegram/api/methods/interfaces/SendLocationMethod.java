package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendLocation;

import java.util.Map;
import java.util.function.Consumer;

public interface SendLocationMethod<R> {

	R sendLocation(Map data);

	R sendLocation(SendLocation data);

	R sendLocation(Consumer<SendLocation> data);
}
