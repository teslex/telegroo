package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.simple.context.MethodsContext

@CompileStatic
trait ReplyTrait implements ContextWithObjectMapper {

	/**
	 * fixme
	 * example: reply(12343) { sendMessage(text: 'Nice') }
	 */
	void reply(replyTo, @DelegatesTo(MethodsContext) Closure closure) {
		def nextApi = api.with {
			clone()
		} as Api

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		closure.delegate = createNewContext(nextApi, lastUpdate, matcher.orElse(null))
		closure.call()
	}

	/**
	 * example: reply { sendMessage(text: 'Nice') }
	 * @param closure
	 */
	void reply(@DelegatesTo(MethodsContext) Closure closure) {
		reply(lastUpdate[lastUpdate.updateType.type]['messageId'], closure)
	}

	/**
	 * example: reply().sendMessage(text: 'Nice')
	 * example: reply(34225).sendMessage(text: 'Nice')
	 * @param replyTo
	 * @return
	 */
	MethodsContext reply(replyTo = lastUpdate[lastUpdate.updateType.type]['messageId']) {
		def nextApi = api.with {
			clone()
		} as Api

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		createNewContext(nextApi, lastUpdate, matcher.orElse(null)) as MethodsContext
	}
}
