package tech.teslex.telegroo.example.bot.commands


import tech.teslex.telegroo.example.annotation.Component
import tech.teslex.telegroo.simple.context.SimpleMessageContext
import tech.teslex.telegroo.simple.update.SimpleMessagePatternUpdateListener
import tech.teslex.telegroo.telegram.attach.Attach

import java.util.regex.Pattern

@Component
class PicMessage implements SimpleMessagePatternUpdateListener {

	Pattern pattern = ~/pic/

	@Override
	void handle(SimpleMessageContext context) {
		context.sendPhoto(photo: Attach.byUrl('https://assets.gitlab-static.net/uploads/-/system/project/avatar/7278100/telegroo.png'))
	}
}