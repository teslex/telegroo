package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait AnswerCallbackQuery {

	def answerCallbackQuery(callbackQueryId = lastUpdate.updateData.callback_query.id, Map params = [:]) {
		api.go(new Some('answerCallbackQuery', [callback_query_id: callbackQueryId] + params))
	}
}
