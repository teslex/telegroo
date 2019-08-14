package tech.teslex.telegroo.simple.update;

import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.methods.Methods;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.UpdateListener;

import java.util.Optional;
import java.util.regex.Pattern;

public class SimpleCommandUpdateListener implements CommandUpdateListener<CommandContext> {

	private final Pattern pattern;
	private final Pattern argsPattern;
	private final UpdateListener<CommandContext> listener;

	public SimpleCommandUpdateListener(Pattern pattern, Pattern argsPattern, UpdateListener<CommandContext> listener) {
		this.pattern = pattern;
		this.argsPattern = argsPattern;
		this.listener = listener;
	}

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public Optional<Pattern> getArgsPattern() {
		return Optional.ofNullable(argsPattern);
	}

	@Override
	public void onUpdate(CommandContext context, Methods methods) {
		listener.onUpdate(context, methods);
	}
}
