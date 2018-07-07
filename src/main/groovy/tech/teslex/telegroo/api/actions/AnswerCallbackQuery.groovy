package tech.teslex.telegroo.api.actions

trait AnswerCallbackQuery {

	def answerCallbackQuery(callbackQueryId = lastUpdate.callback_query.id, Map params = [:]) {
		api.go('answerCallbackQuery', [callback_query_id: callbackQueryId] + params)
	}
}
