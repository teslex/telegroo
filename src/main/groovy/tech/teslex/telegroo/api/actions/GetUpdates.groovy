package tech.teslex.telegroo.api.actions

trait GetUpdates {

	def getUpdates(int offset = 0, int limit = 100, int timeout = 0, List<String> allowedUpdates = []) {
		api.go('getUpdates', [offset: offset])
	}
}