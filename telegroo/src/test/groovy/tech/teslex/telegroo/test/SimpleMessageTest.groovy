package tech.teslex.telegroo.test

import spock.lang.Shared
import spock.lang.Specification
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.telegram.types.InlineKeyboardButton
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup
import tech.teslex.telegroo.telegram.types.input.Attach
import tech.teslex.telegroo.telegram.types.input.InputFile

class SimpleMessageTest extends Specification {

	@Shared
	def props = new Properties().tap { load(new File('src/test/resources/test.properties').newInputStream()) }

	@Shared
	String token = props.token

	@Shared
	Telegroo telegroo = new SimpleTelegroo(token)

	@Shared
	def testChatId = -347437795

	def 'send message'() {
		given:
		def testText = 'Hello, Groovy!'

		when:
		def response = telegroo.mainContext.sendMessage {
			text = testText
			chatId = testChatId
		}

		then:
		response.ok
		response.result.text == testText
	}

	def 'send message with markup'() {
		given:
		def testText = 'Message with url button!'
		def testMarkup = InlineKeyboardMarkup
				.builder()
				.inlineKeyboard([
						[
								InlineKeyboardButton.builder()
										.text('GitLab')
										.url('https://gitlab.com/teslex/telegroo')
										.build()
						]
				]).build()

		when:
		def response = telegroo.mainContext.sendMessage {
			text = testText
			chatId = testChatId
			replyMarkup = testMarkup
		}

		then:
		response.ok
		response.result.text == testText
	}

	def 'send photo by url'() {
		given:
		def testCaption = 'TesLex'
		def testPhoto = Attach.byUrl('https://assets.gitlab-static.net/uploads/-/system/group/avatar/1593121/CAGK4xZfg_M.jpg?width=64')

		when:
		def response = telegroo.mainContext.sendPhoto {
			chatId = testChatId
			caption = testCaption
			photo = testPhoto
		}

		then:
		response.ok
		response.result.photo
		response.result.caption == testCaption
	}
}
