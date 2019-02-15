package tech.teslex.telegroo.test

import spock.lang.Shared
import spock.lang.Specification
import tech.teslex.telegroo.SimpleTelegroo

class SimpleMessageTest extends Specification {

	@Shared
	def token = new File('src/test/resources/token.txt').text

	@Shared
	def telegroo = new SimpleTelegroo(token)

	def 'sendMessage test'() {
		given:
		def chatId = -347437795
		def text = 'Hello, Groovy!'

		when:
		def response = telegroo.sendMessage(text, chatId)

		then:
		response['ok'] == true
		response['result']['text'] == text
	}

	def 'reply test'() {
		given:
		def chatId = -347437795
		def messageId = 983
		def text = 'Hello, Groovy!'

		when:
		def response = telegroo.reply(text, messageId, chatId)

		then:
		response['ok'] == true
		response['result']['text'] == text
	}

	def 'forward test'() {
		given:
		def chatId = -347437795
		def messageId = 983

		when:
		def response = telegroo.forward(chatId, messageId, chatId)

		then:
		response['ok'] == true
		response['result']['text'] == text
	}
}
