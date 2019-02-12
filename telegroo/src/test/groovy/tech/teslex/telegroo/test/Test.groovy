package tech.teslex.telegroo.test

import spock.lang.Specification
import tech.teslex.telegroo.Telegroo

class Test extends Specification {

	def "hello world test"() {
		expect:
		bot.token == token

		where:
		bot                         | token

		new Telegroo("api")         | "api"
		new Telegroo("kek")         | "kek"
		new Telegroo    ("ABCDE:12345") | "ABCDE:12345"
	}
}
