package tech.teslex.telegroo.example.bot.commands

import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.simple.context.SimpleCommandContext
import tech.teslex.telegroo.simple.update.SimpleCommandUpdateListener
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup
import tech.teslex.telegroo.telegram.markup.Markup

import java.util.regex.Pattern

@Component
class InlineKeyboardCommand implements SimpleCommandUpdateListener {

	final Pattern pattern = ~/inline/

	InlineKeyboardMarkup markup = Markup.inlineKeyboard {
		row {
			button text: 'telegroo', url: 'https://teslex.gitlab.io/telegroo'
			button text: 'callback', callbackData: 'cbdata'
		}
	}

	@Override
	void handle(SimpleCommandContext context) {
		context.sendMessage(text: 'Markup', replyMarkup: markup)
	}
}
