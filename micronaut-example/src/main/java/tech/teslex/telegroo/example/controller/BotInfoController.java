package tech.teslex.telegroo.example.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import tech.teslex.telegroo.example.bot.MicronautTelegroo;
import tech.teslex.telegroo.example.conf.BotConfig;

import javax.inject.Inject;

@Controller("/bot/info")
public class BotInfoController {

	private final BotConfig botConfig;
	private final MicronautTelegroo bot;

	@Inject
	public BotInfoController(BotConfig botConfig, MicronautTelegroo bot) {
		this.botConfig = botConfig;
		this.bot = bot;
	}

	@Get("/token")
	public String showToken() {
		return botConfig.getToken();
	}

	@Get("/webhook")
	public Object showWebhookInfo() {
		return bot.methods().getWebhookInfo().getResult();
	}
}
