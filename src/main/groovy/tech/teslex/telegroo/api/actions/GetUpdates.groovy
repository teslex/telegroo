package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait GetUpdates {

	def getUpdates(int offset = 0, int limit = 1--, int timeout = 0, List<String> allowedUpdates = []) {
		api.go(new Some('getUpdates', [offset: offset]))
	}
}