package tech.teslex.telegroo.telegram.api.methods.interfaces.polls;

import tech.teslex.telegroo.telegram.api.methods.objects.polls.SendPoll;

import java.util.Map;
import java.util.function.Consumer;

public interface SendPollMethod<R> {

	R sendPoll(Map data);

	R sendPoll(SendPoll data);

	R sendPoll(Consumer<SendPoll.SendPollBuilder> data);
}
