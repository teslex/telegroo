package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.api.methods.reply.ReplyMethod
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.simple.context.SimpleMethodsContext

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait ReplyTrait implements ReplyMethod {

	/**
	 * example: reply(12343) { sendMessage(text: 'Nice') }*/
	@Override
	void reply(replyTo, @DelegatesTo(SimpleMethodsContext) Closure closure) {
		TelegramClient nextApi = new SimpleTelegramClient((telegramClient as SimpleTelegramClient).token, objectMapper)
		nextApi.defaultParams.put('reply_to_message_id', replyTo)
		Context nextContext = createNewContext(nextApi, update, null)

		closure.delegate = nextContext
		closure()
	}

	/**
	 * example: reply { sendMessage(text: 'Nice') }*/
	@Override
	void reply(@DelegatesTo(SimpleMethodsContext) Closure closure) {
		reply(update[update.updateType.value]['messageId'], closure)
	}

	/**
	 * example: reply().sendMessage(text: 'Nice')
	 * example: reply(34225).sendMessage(text: 'Nice')
	 */
	@Override
	SimpleMethodsContext reply(replyTo = update[update.updateType.value]['messageId']) {
		TelegramClient nextApi = new SimpleTelegramClient((telegramClient as SimpleTelegramClient).token, objectMapper)

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		new SimpleContext(nextApi, update, objectMapper)
	}
}