package tech.teslex.telegroo.example.bot.commands;

import lombok.Getter;
import tech.teslex.telegroo.api.context.CommandContext;
import tech.teslex.telegroo.api.methods.defaults.Methods;
import tech.teslex.telegroo.api.update.defaults.DefaultCommandUpdateListener;

import javax.inject.Singleton;
import java.util.Optional;
import java.util.regex.Pattern;

@Getter
@Singleton
public class EchoCommand implements DefaultCommandUpdateListener {

	private Pattern pattern = Pattern.compile("echo");
	private Pattern argsPattern = Pattern.compile("(.+)");

	@Override
	public void onUpdate(CommandContext context, Methods methods) {
		if (context.getArgsMatcher().find())
			methods.sendMessage(context.getArgsMatcher().group(1));
	}

	@Override
	public Optional<Pattern> getArgsPattern() {
		return Optional.of(argsPattern);
	}
}
