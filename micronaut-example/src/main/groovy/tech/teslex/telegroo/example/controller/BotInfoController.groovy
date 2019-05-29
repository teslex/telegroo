package tech.teslex.telegroo.example.controller

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import tech.teslex.telegroo.example.bot.MicronautTelegroo

import javax.inject.Inject

@CompileStatic
@Controller("/bot/info")
class BotInfoController {

	@Inject
	MicronautTelegroo bot

	@Get("/token")
	def showToken() {
		[token: bot.token]
	}

	@Get("/handlers")
	def showHandlers() {
		bot.handlers
	}

	@Get("/webhook")
	def showWebhookInfo() {
		bot.mainContext.webhookInfo.result
	}
}