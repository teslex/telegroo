package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.AnswerInlineQueryMethodObject

@CompileStatic
trait AnswerInlineQueryMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> answerInlineQuery(@NamedDelegate AnswerInlineQueryMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> answerInlineQuery(Map data) {
		answerInlineQuery(data as AnswerInlineQueryMethodObject)
	}

	TelegramResult<Object> answerInlineQuery(@DelegatesTo(AnswerInlineQueryMethodObject) Closure closure) {
		def builder = AnswerInlineQueryMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		answerInlineQuery(builder)
	}
}
