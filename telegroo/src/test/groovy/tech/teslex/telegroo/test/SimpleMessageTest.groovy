package tech.teslex.telegroo.test

import spock.lang.Shared
import tech.teslex.telegroo.simple.SimpleTelegroo

class SimpleMessageTest /* extends Specification */ {

	@Shared
	def token = new File('src/test/resources/token.txt').text

	@Shared
	def telegroo = new SimpleTelegroo(token)

	def 'sendMessage test'() {
		given:
		def chatId = -347437795
		def text = 'Hello, Groovy!'

		when:
		def response = telegroo.sendMessage(text: text, chatId: chatId)

		then:
		response['ok'] == true
		response['result']['text'] == text
	}

	def 'forward test'() {
		given:
		def chatId = -347437795
		def messageId = 983
		def text = 'Hello, Groovy!'

		when:
		def response = telegroo.forwardMessage(fromChatId: chatId, messageId: messageId, chatId: chatId)

		then:
		response.ok
		response.result.text == text
	}
}
