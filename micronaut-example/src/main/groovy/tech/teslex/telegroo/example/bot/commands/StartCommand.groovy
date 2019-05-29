package tech.teslex.telegroo.example.bot.commands

import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.simple.context.SimpleCommandContext
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener

import java.util.regex.Pattern

@Component
class StartCommand implements SimpleCommandUpdateListener {

	Pattern pattern = ~/start/

	@Override
	void handle(SimpleCommandContext context) {
		context.sendMessage(text: 'Welcome!')
	}
}
