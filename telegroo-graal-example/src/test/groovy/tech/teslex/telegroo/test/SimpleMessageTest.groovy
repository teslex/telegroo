//package tech.teslex.telegroo.test
//
//import spock.lang.Shared
//import spock.lang.Specification
//import tech.teslex.telegroo.simple.SimplePollingTelegroo
//import tech.teslex.telegroo.telegram.api.types.InlineKeyboardButton
//import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup
//import tech.teslex.telegroo.telegram.attach.Attach
//
//class SimpleMessageTest extends Specification {
//
//	@Shared
//	def props = new Properties().tap { load(new File('src/test/resources/test.properties').newInputStream()) }
//
//	@Shared
//	String token = props.token
//
//	@Shared
//	SimplePollingTelegroo telegroo = new SimplePollingTelegroo(token)
//
//	@Shared
//	def testChatId = -347437795
//
//	def 'send message'() {
//		given:
//		def testText = 'Hello, Groovy!'
//
//		when:
//		def response = telegroo.mainContext.sendMessage {
//			text = testText
//			chatId = testChatId
//		}
//
//		then:
//		response.ok
//		response.result.text == testText
//	}
//
//	def 'send message with markup'() {
//		given:
//		def testText = 'Message with url button!'
//		def testMarkup = InlineKeyboardMarkup
//				.builder()
//				.inlineKeyboard([
//						[
//								InlineKeyboardButton.builder()
//										.text('GitLab')
//										.url('https://gitlab.com/teslex/telegroo')
//										.build()
//						]
//				]).build()
//
//		when:
//		def response = telegroo.mainContext.sendMessage {
//			text = testText
//			chatId = testChatId
//			replyMarkup = testMarkup
//		}
//
//		then:
//		response.ok
//		response.result.text == testText
//	}
//
//	def 'send photo by url'() {
//		given:
//		def testCaption = 'TesLex'
//		def testPhoto = Attach.byUrl('https://assets.gitlab-static.net/uploads/-/system/group/avatar/1593121/CAGK4xZfg_M.jpg?width=64')
//
//		when:
//		def response = telegroo.mainContext.sendPhoto {
//			chatId = testChatId
//			caption = testCaption
//			photo = testPhoto
//		}
//
//		then:
//		response.ok
//		response.result.photo
//		response.result.caption == testCaption
//	}
//
//	/*def 'send media photos'() {
//		given:
//		def mediaList = [
//				AttachMedia.photo(Attach.byUrl('https://assets.gitlab-static.net/uploads/-/system/project/avatar/7278100/telegroo.png')),
//				AttachMedia.photo(Attach.byUrl('https://assets.gitlab-static.net/uploads/-/system/group/avatar/1593121/CAGK4xZfg_M.jpg'))
//		]
//
//		when:
//		def response = telegroo.mainContext.sendMediaGroup {
//			media = mediaList
//		}
//
//		then:
//		response.ok
//		response.result
//	}*/
//}
