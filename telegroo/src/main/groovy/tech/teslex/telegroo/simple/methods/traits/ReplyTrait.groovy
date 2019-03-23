package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.simple.context.SimpleContext

@CompileStatic
trait ReplyTrait implements ContextWithObjectMapper {

	/**
	 * fixme
	 * example: reply(12343) { sendMessage(text: 'Nice') }*/
	void reply(replyTo, @DelegatesTo(MethodsContext) Closure closure) {
		def nextApi = api.with {
			clone()
		} as Api

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		closure.delegate = createNewContext(nextApi, lastUpdate, matcher ?: null)
		closure.call()
	}

	/**
	 * example: reply { sendMessage(text: 'Nice') }*/
	void reply(@DelegatesTo(MethodsContext) Closure closure) {
		reply(lastUpdate[lastUpdate.updateType.value]['messageId'], closure)
	}

	/**
	 * example: reply().sendMessage(text: 'Nice')
	 * example: reply(34225).sendMessage(text: 'Nice')
	 */
	SimpleContext reply(replyTo = lastUpdate[lastUpdate.updateType.value]['messageId']) {
		def nextApi = api.with {
			clone()
		} as Api

		nextApi.defaultParams.put('reply_to_message_id', replyTo)

		createNewContext(nextApi, lastUpdate, matcher ?: null) as SimpleContext
	}
}
