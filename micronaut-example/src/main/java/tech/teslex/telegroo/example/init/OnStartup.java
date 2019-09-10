package tech.teslex.telegroo.example.init;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.update.CommandUpdateListener;
import tech.teslex.telegroo.api.update.MessagePatternUpdateListener;
import tech.teslex.telegroo.example.bot.BotUpdateListener;
import tech.teslex.telegroo.example.bot.MicronautTelegroo;
import tech.teslex.telegroo.example.conf.BotConfig;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Slf4j
@Singleton
public class OnStartup implements ApplicationEventListener<StartupEvent> {

	private final BotConfig config;
	private final MicronautTelegroo telegroo;

	private final List<BotUpdateListener> updateListeners;
	private final List<CommandUpdateListener> commandsListeners;
	private final List<MessagePatternUpdateListener> messagesListeners;

	@Inject
	public OnStartup(BotConfig config, MicronautTelegroo telegroo, List<BotUpdateListener> updateListeners, List<CommandUpdateListener> commandsListeners, List<MessagePatternUpdateListener> messagesListeners) {
		this.config = config;
		this.telegroo = telegroo;
		this.updateListeners = updateListeners;
		this.commandsListeners = commandsListeners;
		this.messagesListeners = messagesListeners;
	}

	@Override
	public void onApplicationEvent(StartupEvent event) {
		updateListeners.forEach(telegroo::listen);
		commandsListeners.forEach(telegroo::listenCommand);
		messagesListeners.forEach(telegroo::listenMessage);

		log.info("Setting webhook..");
		log.info("Webhook was set: " + telegroo.methods().setWebhook(config.getWebhookUrl()));
	}
}
