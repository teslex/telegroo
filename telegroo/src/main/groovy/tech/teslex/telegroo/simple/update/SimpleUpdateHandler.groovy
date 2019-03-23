package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.UpdateHandler

@CompileStatic
interface SimpleUpdateHandler extends UpdateHandler<MethodsContext> {
}