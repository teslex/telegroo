package tech.teslex.telegroo.api.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerPreCheckoutQueryMethodObject

@CompileStatic
trait AnswerPreCheckoutQueryMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> answerPreCheckoutQuery(@NamedDelegate AnswerPreCheckoutQueryMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> answerPreCheckoutQuery(Map data) {
		answerPreCheckoutQuery(data as AnswerPreCheckoutQueryMethodObject)
	}

	TelegramResult<Object> answerPreCheckoutQuery(@DelegatesTo(AnswerPreCheckoutQueryMethodObject) Closure closure) {
		def builder = AnswerPreCheckoutQueryMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		answerPreCheckoutQuery(builder)
	}
}