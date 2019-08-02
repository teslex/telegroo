package tech.teslex.telegroo.simple;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.Telegroo;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener;
import tech.teslex.telegroo.simple.update.SimpleMessagePatternUpdateListener;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
public abstract class AbstractTelegroo implements Telegroo {

	protected final static Map<UpdateType, Collection<UpdateListener>> listeners = new HashMap<>();

	@Override
	public void listen(UpdateListener listener) {
		addListener(listener);
	}

	protected void addListener(UpdateListener listener) {
		log.debug("adding new listener: " + listener);

		if (!listeners.containsKey(listener.getType())) listeners.put(listener.getType(), new ArrayList<>());
		listeners
				.get(listener.getType())
				.add(listener);
	}


	@Override
	public void listenMessage(Pattern pattern, UpdateListener<MessageContext> listener) {
		addListener(new SimpleMessagePatternUpdateListener(pattern, listener));
	}

	@Override
	public void listenCommand(Pattern pattern, UpdateListener<CommandContext> listener) {
		addListener(new SimpleCommandUpdateListener(pattern, null, listener));
	}
}
