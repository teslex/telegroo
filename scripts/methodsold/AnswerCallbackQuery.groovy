package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.CallbackQuery

@CompileStatic
trait AnswerCallbackQuery extends AbstractContext {

	CallbackQuery answerCallbackQuery(callbackQueryId = lastUpdate.updateData['callback_query']['id'], Map params = [:]) {
		def result = api.go(new Some('answerCallbackQuery', [callback_query_id: callbackQueryId] + params))['result'] as Map

		m2c2m(result, CallbackQuery) as CallbackQuery
	}
}
