package tech.teslex.telegroo.api.update

interface UpdateHandler {

	def handle(Update update, Map handlers)
}
