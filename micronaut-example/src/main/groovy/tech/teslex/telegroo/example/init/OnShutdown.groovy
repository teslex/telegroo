package tech.teslex.telegroo.example.init

import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.ShutdownEvent
import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.example.bot.MicronautTelegroo

import javax.inject.Inject

@Component
class OnShutdown implements ApplicationEventListener<ShutdownEvent> {

	@Inject
	MicronautTelegroo telegroo

	@Override
	void onApplicationEvent(ShutdownEvent event) {
		log.info(telegroo.mainContext.deleteWebhook().toString())
	}
}

