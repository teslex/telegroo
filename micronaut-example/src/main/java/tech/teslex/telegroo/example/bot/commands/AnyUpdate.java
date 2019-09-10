package tech.teslex.telegroo.example.bot.commands;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.methods.defaults.Methods;
import tech.teslex.telegroo.example.bot.BotUpdateListener;

import javax.inject.Singleton;

@Singleton
public class AnyUpdate implements BotUpdateListener {

	@Override
	public void onUpdate(Context context, Methods methods) {
		// todo: do nothing here..
	}
}
