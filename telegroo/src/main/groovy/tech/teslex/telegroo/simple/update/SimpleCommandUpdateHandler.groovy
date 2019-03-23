package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.CommandUpdateHandler

@CompileStatic
interface SimpleCommandUpdateHandler extends CommandUpdateHandler<MethodsContext> {
}