package tech.teslex.telegroo.example.bot

import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.example.conf.BotConfig
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.simple.update.SimpleUpdatesHandler
import tech.teslex.telegroo.telegram.api.types.update.Update

import javax.annotation.PostConstruct
import javax.inject.Inject

@Component
class MicronautTelegroo extends SimpleTelegroo {

	@Inject
	BotConfig botConfig

	@PostConstruct
	void init() {
		this.token = botConfig.token
		this.telegramClient = new SimpleTelegramClient(token)
		this.mainContext = new SimpleMethodsContext(telegramClient, new Update(updateId: 0))
		this.updateHandlersSolver = new SimpleUpdatesHandler(this)
	}
}