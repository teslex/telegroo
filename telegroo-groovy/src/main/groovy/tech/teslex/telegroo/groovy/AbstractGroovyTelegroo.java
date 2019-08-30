package tech.teslex.telegroo.groovy;

import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.simple.AbstractTelegroo;

import java.util.regex.Pattern;

public class AbstractGroovyTelegroo extends AbstractTelegroo {

	public AbstractGroovyTelegroo(String token) {
		super(token);
	}

	@Override
	public void listenCommand(Pattern pattern, Pattern args, UpdateListener<CommandContext> listener) {
		super.listenCommand(pattern, args, listener);
	}
}
