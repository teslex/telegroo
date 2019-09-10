package tech.teslex.telegroo.example.init;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.ShutdownEvent;
import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.example.bot.MicronautTelegroo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class OnShutdown implements ApplicationEventListener<ShutdownEvent> {

	private final MicronautTelegroo telegroo;

	@Inject
	public OnShutdown(MicronautTelegroo telegroo) {
		this.telegroo = telegroo;
	}

	@Override
	public void onApplicationEvent(ShutdownEvent event) {
		log.info("Deleting webhook..");
		log.info("Webhook was deleted: " + telegroo.methods().deleteWebhook());
	}
}
