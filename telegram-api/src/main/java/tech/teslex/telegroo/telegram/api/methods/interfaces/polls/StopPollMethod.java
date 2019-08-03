package tech.teslex.telegroo.telegram.api.methods.interfaces.polls;

import tech.teslex.telegroo.telegram.api.methods.objects.polls.StopPoll;

import java.util.Map;
import java.util.function.Consumer;

public interface StopPollMethod<R> {

	R stopPoll(Map data);

	R stopPoll(StopPoll data);

	R stopPoll(Consumer<StopPoll.StopPollBuilder> data);
}
