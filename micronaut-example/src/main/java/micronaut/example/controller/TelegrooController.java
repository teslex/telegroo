package micronaut.example.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.exceptions.HttpStatusException;
import micronaut.example.bot.MicronautTelegroo;
import micronaut.example.config.TelegrooConfig;
import tech.teslex.telegroo.telegram.api.types.update.Update;

import java.util.Collections;

@Controller("/telegroo")
public class TelegrooController {

	private final TelegrooConfig telegrooConfig;

	private final MicronautTelegroo telegroo;

	public TelegrooController(TelegrooConfig telegrooConfig, MicronautTelegroo telegroo) {
		this.telegrooConfig = telegrooConfig;
		this.telegroo = telegroo;
	}

	@Post("/{botToken}/handle")
	void handleUpdate(@PathVariable String botToken, @Body Update update) {
		if (botToken.equals(telegrooConfig.getToken()))
			telegroo.handleUpdates(Collections.singletonList(update));
		else
			throw new HttpStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
	}
}
