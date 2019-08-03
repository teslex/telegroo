package micronaut.example.event;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import lombok.extern.slf4j.Slf4j;
import micronaut.example.bot.MicronautTelegroo;
import micronaut.example.config.TelegrooConfig;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class OnStartup implements ApplicationEventListener<StartupEvent> {

	private final TelegrooConfig config;

	private final MicronautTelegroo telegroo;

	public OnStartup(TelegrooConfig config, MicronautTelegroo telegroo) {
		this.config = config;
		this.telegroo = telegroo;
	}

	@Override
	public void onApplicationEvent(StartupEvent event) {
		telegroo.listenCommand("echo", context -> context.sendMessage(context.getArgsText()));

		telegroo.getMainContext().deleteWebhook();
		telegroo.getMainContext()
				.setWebhook(webhook -> log.warn(webhook.url(config.getWebhookUrl()).toString()));
	}
}
