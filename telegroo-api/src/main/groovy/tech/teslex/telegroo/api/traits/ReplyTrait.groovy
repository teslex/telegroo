package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.api.context.MethodsContext

@CompileStatic
trait ReplyTrait implements Context {

	/**
	 * fixme
	 */
	void reply(replyTo, @DelegatesTo(MethodsContext) Closure closure) {
		def nextApi = api.with {
			clone()
		} as Api

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		closure.delegate = createNewContext(nextApi, lastUpdate, jacksonObjectMapper, matcher.orElse(null))
		closure.call()
	}

	void reply(@DelegatesTo(MethodsContext) Closure closure) {
		reply(lastUpdate[lastUpdate.updateType.type]['messageId'], closure)
	}
}
