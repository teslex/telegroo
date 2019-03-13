package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.UpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

@CompileStatic
interface Telegroo {

	def start()

	def stop()


	void on(UpdateType type, @DelegatesTo(MethodsContext) Closure handler)

	void onUpdate(@DelegatesTo(MethodsContext) Closure handler)

	void onCommand(String command, @DelegatesTo(MethodsContext) Closure handler)

	void onMessage(String message, @DelegatesTo(MethodsContext) Closure handler)


	void onUpdateHandler(UpdateType type, UpdateHandler handler)

	void onUpdateUpdateHandler(UpdateHandler handler)

	void onCommandUpdateHandler(String command, UpdateHandler handler)

	void onMessageUpdateHandler(String message, UpdateHandler handler)
}
