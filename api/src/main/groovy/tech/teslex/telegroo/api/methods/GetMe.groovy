package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetMe {

	def getMe() {
		api.go(new Some('getMe'))
	}
}
