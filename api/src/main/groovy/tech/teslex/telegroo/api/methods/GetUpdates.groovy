package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetUpdates {

	def getUpdates(offset = 0, limit = 0, timeout = 0, List<String> allowedUpdates = []) {
		api.go(new Some('getUpdates', [offset: offset]))
	}
}