package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.AnswerInlineQueryMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.AnswerInlineQueryMethodObject

@CompileStatic
trait AnswerInlineQueryMethodTrait implements AnswerInlineQueryMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> answerInlineQuery(@NamedDelegate AnswerInlineQueryMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> answerInlineQuery(Map data) {
		answerInlineQuery(data as AnswerInlineQueryMethodObject)
	}

	@Override
	TelegramResult<Object> answerInlineQuery(@DelegatesTo(AnswerInlineQueryMethodObject) Closure closure) {
		def builder = AnswerInlineQueryMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		answerInlineQuery(builder)
	}
}
