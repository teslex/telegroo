package micronaut.example.event;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.ShutdownEvent;
import lombok.extern.slf4j.Slf4j;
import micronaut.example.bot.MicronautTelegroo;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class OnShutdown implements ApplicationEventListener<ShutdownEvent> {

	private final MicronautTelegroo telegroo;

	public OnShutdown(MicronautTelegroo telegroo) {
		this.telegroo = telegroo;
	}

	@Override
	public void onApplicationEvent(ShutdownEvent event) {
		log.warn(telegroo.getMainContext().deleteWebhook().toString());
	}
}
