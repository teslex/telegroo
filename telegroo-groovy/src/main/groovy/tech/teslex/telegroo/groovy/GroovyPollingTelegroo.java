package tech.teslex.telegroo.groovy;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.simple.SimplePollingTelegroo;

public class GroovyPollingTelegroo extends SimplePollingTelegroo {

	public GroovyPollingTelegroo(String token) {
		super(token);
	}

	@Override
	public void listenCommand(String pattern, @DelegatesTo(value = CommandContext.class, strategy = Closure.DELEGATE_FIRST) UpdateListener<CommandContext> listener) {

	}
}