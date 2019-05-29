package tech.teslex.telegroo.example.bot.callback

import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.simple.update.SimpleCallbackQueryUpdateListener

@Component
class ClbackListener implements SimpleCallbackQueryUpdateListener {

	String callbackData = 'cbdata'

	@Override
	void handle(SimpleMethodsContext context) {
		context.sendMessage {
			chatId = context.update.callbackQuery.message.chat.id
			text = 'Call Backed!'
		}
	}
}