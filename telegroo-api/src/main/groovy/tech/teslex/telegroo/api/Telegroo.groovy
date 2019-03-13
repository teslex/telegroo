package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.UpdateHandler

@CompileStatic
interface Telegroo {

	def start()

	def stop()

	def on(String type, UpdateHandler handler)

	def onUpdate(UpdateHandler handler)

	def onCommand(String command, UpdateHandler handler)

	def onMessage(String message, UpdateHandler handler)
}
