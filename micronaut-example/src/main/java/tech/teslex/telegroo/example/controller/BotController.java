package tech.teslex.telegroo.example.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import tech.teslex.telegroo.example.bot.MicronautTelegroo;
import tech.teslex.telegroo.example.conf.BotConfig;
import tech.teslex.telegroo.telegram.api.methods.objects.webhook.SetWebhook;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import javax.inject.Inject;
import java.util.Collections;

@Controller("/bot")
public class BotController {

	private final BotConfig config;
	private final MicronautTelegroo bot;

	@Inject
	public BotController(BotConfig config, MicronautTelegroo bot) {
		this.config = config;
		this.bot = bot;
	}

	@Get("/init")
	public Object initWebhook() {
		return bot
				.methods()
				.setWebhook(config.getWebhookUrl())
				.getResult();
	}

	@Post("/{botToken}/handle")
	public void handleUpdate(@PathVariable String botToken, @Body Update update) {

		if (botToken.equals(config.getToken()))
			bot.handleUpdates(Collections.singletonList(update));
		else
			throw new HttpStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
	}
}
