package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.StopMessageLiveLocation;

import java.util.Map;
import java.util.function.Consumer;

public interface StopMessageLiveLocationMethod<R> {

	R stopMessageLiveLocation(Map data);

	R stopMessageLiveLocation(StopMessageLiveLocation data);

	R stopMessageLiveLocation(Consumer<StopMessageLiveLocation> data);
}
