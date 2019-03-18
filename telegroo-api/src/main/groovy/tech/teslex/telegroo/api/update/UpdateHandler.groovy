package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext

@CompileStatic
interface UpdateHandler extends UpdateGetTypeTrait {

	void handle(MethodsContext context);
}