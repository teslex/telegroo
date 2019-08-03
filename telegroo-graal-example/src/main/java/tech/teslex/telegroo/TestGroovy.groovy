//package tech.teslex.telegroo
//
//import groovy.util.logging.Slf4j
//import tech.teslex.telegroo.api.PollingTelegroo
//import tech.teslex.telegroo.simple.SimplePollingTelegroo
//
//@Slf4j
//class TestGroovy {
//
//	private final static PollingTelegroo telegroo = new SimplePollingTelegroo("531557312:AAHWld_ahP04ijdY5XPYEuFzZ8co1xSjGzo")
//
//	static void main(String[] args) {
//
//		telegroo.listenMessage("echo") { context ->
//			log.info(context.matcher)
//		}
//
//		telegroo.listenCommand("echo") {
//			sendMessage('ok')
//		}
//
//		telegroo.startPolling()
//	}
//}