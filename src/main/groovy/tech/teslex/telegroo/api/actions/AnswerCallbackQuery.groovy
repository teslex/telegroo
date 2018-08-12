package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait AnswerCallbackQuery {

	def answerCallbackQuery(callbackQueryId = lastUpdate.callback_query.id, Map params = [:]) {
		api.go(new Some('answerCallbackQuery', [callback_query_id: callbackQueryId] + params))
	}
}
