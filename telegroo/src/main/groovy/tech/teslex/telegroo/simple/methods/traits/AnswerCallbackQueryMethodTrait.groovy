package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.AnswerCallbackQueryMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.AnswerCallbackQueryMethodObject

@CompileStatic
trait AnswerCallbackQueryMethodTrait implements AnswerCallbackQueryMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> answerCallbackQuery(@NamedDelegate AnswerCallbackQueryMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> answerCallbackQuery(Map data) {
		answerCallbackQuery(data as AnswerCallbackQueryMethodObject)
	}

	@Override
	TelegramResult<Object> answerCallbackQuery(@DelegatesTo(AnswerCallbackQueryMethodObject) Closure closure) {
		def builder = AnswerCallbackQueryMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		answerCallbackQuery(builder)
	}
}
