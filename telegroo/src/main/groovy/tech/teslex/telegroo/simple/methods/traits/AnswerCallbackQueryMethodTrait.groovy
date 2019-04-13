package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.AnswerCallbackQueryMethod
import tech.teslex.telegroo.telegram.methods.objects.AnswerCallbackQueryMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait AnswerCallbackQueryMethodTrait implements AnswerCallbackQueryMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> answerCallbackQuery(@NamedDelegate AnswerCallbackQueryMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> answerCallbackQuery(Map data) {
		answerCallbackQuery(data as AnswerCallbackQueryMethodObject)
	}

	@Override
	TelegramResult<Object> answerCallbackQuery(@DelegatesTo(AnswerCallbackQueryMethodObject) Closure closure) {
		AnswerCallbackQueryMethodObject builder = new AnswerCallbackQueryMethodObject()
		closure.delegate = builder
		closure.call()
		answerCallbackQuery(builder)
	}
}
