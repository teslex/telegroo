package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.MessageUpdateHandler
import tech.teslex.telegroo.simple.context.MethodsContext

@CompileStatic
interface SimpleMessageUpdateHandler extends MessageUpdateHandler<MethodsContext> {
}