package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.simple.context.MethodsContext;

@CompileStatic
interface SimpleUpdateHandler extends UpdateHandler<MethodsContext> {
}