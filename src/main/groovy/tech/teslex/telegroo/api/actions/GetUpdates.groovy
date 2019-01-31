package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait GetUpdates {

	def getUpdates(offset = 0, limit = 1--, timeout = 0, List<String> allowedUpdates = []) {
		api.go(new Some('getUpdates', [offset: offset]))
	}
}