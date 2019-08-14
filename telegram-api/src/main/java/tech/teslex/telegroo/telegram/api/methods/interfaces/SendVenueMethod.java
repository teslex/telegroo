package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendVenue;

import java.util.Map;
import java.util.function.Consumer;

public interface SendVenueMethod<R> {

	R sendVenue(Map data);

	R sendVenue(SendVenue data);

	R sendVenue(Consumer<SendVenue> data);
}
