package tech.teslex.telegroo.api.methods.reply

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext

@CompileStatic
interface ReplyMethod {

	void reply(Object replyTo, Closure closure)

	void reply(@DelegatesTo(MethodsContext.class) Closure closure)

	MethodsContext reply(Object replyTo)

	MethodsContext reply()
}
