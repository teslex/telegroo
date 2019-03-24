package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.methods.reply.ReplyMethod
import tech.teslex.telegroo.simple.SimpleApi
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.simple.context.SimpleMethodsContext

@CompileStatic
trait ReplyTrait implements ReplyMethod, ContextWithObjectMapper {

	/**
	 * example: reply(12343) { sendMessage(text: 'Nice') }*/
	@Override
	void reply(replyTo, @DelegatesTo(SimpleMethodsContext) Closure closure) {
		Api nextApi = new SimpleApi((api as SimpleApi).token, objectMapper)
		nextApi.defaultParams.put('reply_to_message_id', replyTo)
		Context nextContext = createNewContext(nextApi, lastUpdate, null)

		closure.delegate = nextContext
		closure()
	}

	/**
	 * example: reply { sendMessage(text: 'Nice') }*/
	@Override
	void reply(@DelegatesTo(SimpleMethodsContext) Closure closure) {
		reply(lastUpdate[lastUpdate.updateType.value]['messageId'], closure)
	}

	/**
	 * example: reply().sendMessage(text: 'Nice')
	 * example: reply(34225).sendMessage(text: 'Nice')
	 */
	@Override
	MethodsContext reply(replyTo = lastUpdate[lastUpdate.updateType.value]['messageId']) {
		Api nextApi = new SimpleApi((api as SimpleApi).token, objectMapper)

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		createNewContext(nextApi, lastUpdate, null) as MethodsContext
	}
}