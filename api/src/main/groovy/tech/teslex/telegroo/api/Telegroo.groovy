package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.update.CommandHandler
import tech.teslex.telegroo.api.update.MessageHandler
import tech.teslex.telegroo.api.update.UpdateHandler

interface Telegroo {

	def start()

	def stop()

	def on(String type, UpdateHandler handler)

	def onUpdate(UpdateHandler handler)

	def onCommand(String command, CommandHandler handler)

	def onMessage(String message, MessageHandler handler)
}
