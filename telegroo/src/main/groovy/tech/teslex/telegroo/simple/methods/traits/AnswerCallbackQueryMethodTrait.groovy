package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.AnswerCallbackQueryMethodObject

@CompileStatic
trait AnswerCallbackQueryMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> answerCallbackQuery(@NamedDelegate AnswerCallbackQueryMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> answerCallbackQuery(Map data) {
		answerCallbackQuery(data as AnswerCallbackQueryMethodObject)
	}

	TelegramResult<Object> answerCallbackQuery(@DelegatesTo(AnswerCallbackQueryMethodObject) Closure closure) {
		def builder = AnswerCallbackQueryMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		answerCallbackQuery(builder)
	}
}
