package tech.teslex.telegroo.simple.methods.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.payments.AnswerPreCheckoutQueryMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerPreCheckoutQueryMethodObject

@CompileStatic
trait AnswerPreCheckoutQueryMethodTrait implements AnswerPreCheckoutQueryMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> answerPreCheckoutQuery(@NamedDelegate AnswerPreCheckoutQueryMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> answerPreCheckoutQuery(Map data) {
		answerPreCheckoutQuery(data as AnswerPreCheckoutQueryMethodObject)
	}

	@Override
	TelegramResult<Object> answerPreCheckoutQuery(@DelegatesTo(AnswerPreCheckoutQueryMethodObject) Closure closure) {
		def builder = AnswerPreCheckoutQueryMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		answerPreCheckoutQuery(builder)
	}
}