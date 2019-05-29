package tech.teslex.telegroo.example.init

import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.example.bot.MicronautTelegroo
import tech.teslex.telegroo.example.bot.wrap.BotUpdateListener
import tech.teslex.telegroo.example.conf.BotConfig
import tech.teslex.telegroo.simple.update.SimpleCallbackQueryUpdateListener
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener
import tech.teslex.telegroo.simple.update.SimpleMessagePatternUpdateListener

import javax.inject.Inject

@Component
class OnStartup implements ApplicationEventListener<StartupEvent> {

	@Inject
	BotConfig config

	@Inject
	MicronautTelegroo telegroo

	@Inject
	List<SimpleCommandUpdateListener> commandsHandlers

	@Inject
	List<SimpleMessagePatternUpdateListener> messagesHandlers

	@Inject
	List<SimpleCallbackQueryUpdateListener> callbackQueryHandlers

	@Inject
	List<BotUpdateListener> updateHandlers

	@Override
	void onApplicationEvent(StartupEvent event) {
		updateHandlers.each(telegroo.&updateListener)
		messagesHandlers.each(telegroo.&messageUpdateListener)
		commandsHandlers.each(telegroo.&commandUpdateListener)
		callbackQueryHandlers.each(telegroo.&callbackQueryUpdateListener)

		log.info("Token: $telegroo.token")
		log.info("Webhook: $config.webhookUrl")
		log.warn(telegroo.mainContext.setWebhook(url: config.webhookUrl) as String)
	}
}
