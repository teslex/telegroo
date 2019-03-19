package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.simple.context.MethodsContext

@CompileStatic
trait ReplyTrait implements Context<Response> {

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
