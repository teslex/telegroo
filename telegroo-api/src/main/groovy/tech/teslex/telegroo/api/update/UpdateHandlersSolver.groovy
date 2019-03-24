package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
interface UpdateHandlersSolver {

	void solve(Update update, List<UpdateHandler> handlers)
}