package tech.teslex.telegroo.example.bot.commands

import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.simple.context.SimpleCommandContext
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener

import java.util.regex.Pattern

@Component
class EchoCommand implements SimpleCommandUpdateListener {

	Pattern pattern = ~/echo/

	Pattern argsPattern = ~/(.+)/

	@Override
	void handle(SimpleCommandContext context) {
		if (context.argsMatcher.find())
			context.reply().sendMessage(text: context.argsMatcher.group(1))
	}
}
