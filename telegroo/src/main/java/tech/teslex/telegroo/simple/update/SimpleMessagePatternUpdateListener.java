package tech.teslex.telegroo.simple.update;

import tech.teslex.telegroo.api.context.MessageContext;
import tech.teslex.telegroo.api.methods.defaults.Methods;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.simple.context.SimpleMessageContext;

import java.util.regex.Pattern;

public class SimpleMessagePatternUpdateListener implements MessagePatternUpdateListener<SimpleMessageContext> {

	private final Pattern pattern;
	private final UpdateListener<MessageContext> listener;

	public SimpleMessagePatternUpdateListener(Pattern pattern, UpdateListener<MessageContext> listener) {
		this.pattern = pattern;
		this.listener = listener;
	}

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public void onUpdate(SimpleMessageContext context, Methods methods) {
		listener.onUpdate(context, methods);
	}
}
