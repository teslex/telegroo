package tech.teslex.telegroo.api.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerShippingQueryMethodObject

@CompileStatic
trait AnswerShippingQueryMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> answerShippingQuery(@NamedDelegate AnswerShippingQueryMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> answerShippingQuery(Map data) {
		answerShippingQuery(new AnswerShippingQueryMethodObject(data))
	}
}
