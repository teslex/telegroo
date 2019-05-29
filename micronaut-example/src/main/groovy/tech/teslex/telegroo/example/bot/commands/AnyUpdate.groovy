package tech.teslex.telegroo.example.bot.commands


import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.example.bot.wrap.BotUpdateListener
import tech.teslex.telegroo.simple.context.SimpleMethodsContext

@Component
class AnyUpdate implements BotUpdateListener {

	@Override
	void handle(SimpleMethodsContext context) {
		log.info(context.update as String)
	}
}