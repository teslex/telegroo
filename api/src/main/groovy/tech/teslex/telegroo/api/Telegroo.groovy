package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.res.UpdateResolver

interface Telegroo {

	def start()

	def stop()

	def on(String type, UpdateResolver resolver)

	def onCommand(String command, UpdateResolver resolver)

	def onMessage(String message, UpdateResolver resolver)

	def onUpdate(UpdateResolver updateResolver)
}
