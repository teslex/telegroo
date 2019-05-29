package tech.teslex.telegroo.example.controller

import groovy.transform.CompileStatic
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.http.exceptions.HttpStatusException
import tech.teslex.telegroo.example.bot.MicronautTelegroo
import tech.teslex.telegroo.example.conf.BotConfig
import tech.teslex.telegroo.telegram.api.types.update.Update

import javax.inject.Inject

@CompileStatic
@Controller("/bot")
class BotController {

	@Inject
	BotConfig config

	@Inject
	MicronautTelegroo bot

	@Get("/init")
	String initWebhook() {
		bot.mainContext.setWebhook(url: config.webhookUrl)
	}

	@Post("/{botToken}/handle")
	void handleUpdate(@PathVariable String botToken, @Body Update update) {
		if (botToken == config.token)
			bot.solveUpdates([update])
		else
			throw new HttpStatusException(HttpStatus.UNAUTHORIZED, 'Invalid token')
	}
}
