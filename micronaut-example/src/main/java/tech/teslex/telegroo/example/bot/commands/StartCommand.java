package tech.teslex.telegroo.example.bot.commands;

import lombok.Getter;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.methods.defaults.Methods;
import tech.teslex.telegroo.api.update.defaults.DefaultCommandUpdateListener;

import javax.inject.Singleton;
import java.util.regex.Pattern;

@Getter
@Singleton
public class StartCommand implements DefaultCommandUpdateListener {

	private Pattern pattern = Pattern.compile("start");

	@Override
	public void onUpdate(CommandContext context, Methods methods) {
		methods.sendMessage("Hello!");
	}
}
