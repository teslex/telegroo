package tech.teslex.telegroo;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.PollingTelegroo;
import tech.teslex.telegroo.simple.SimplePollingTelegroo;

@Slf4j
public class Test {

	private final static PollingTelegroo telegroo = new SimplePollingTelegroo("531557312:AAHWld_ahP04ijdY5XPYEuFzZ8co1xSjGzo");

	public static void main(String[] args) {
		telegroo.listenMessage("echo", context -> log.info(context.getMatcher().toString()));
		telegroo.listenCommand("echo", context -> context.sendMessage(message -> message.text(context.getArgsText())));
		telegroo.startPolling();
	}
}