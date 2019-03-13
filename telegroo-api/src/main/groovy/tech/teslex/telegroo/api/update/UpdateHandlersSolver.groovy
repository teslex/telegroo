package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
interface UpdateHandlersSolver {

	def solve(Update update, Map handlersClosures, Map handlersUpdates)
}
