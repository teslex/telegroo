package tech.teslex.telegroo.example.bot;

import tech.teslex.telegroo.example.conf.BotConfig;
import tech.teslex.telegroo.simple.AbstractTelegroo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MicronautTelegroo extends AbstractTelegroo {

	@Inject
	public MicronautTelegroo(BotConfig botConfig) {
		super(botConfig.getToken());
	}
}
