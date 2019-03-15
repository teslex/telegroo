package tech.teslex.telegroo.api.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerPreCheckoutQueryMethodObject

@CompileStatic
trait AnswerPreCheckoutQueryMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> answerPreCheckoutQuery(@NamedDelegate AnswerPreCheckoutQueryMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> answerPreCheckoutQuery(Map data) {
		answerPreCheckoutQuery(new AnswerPreCheckoutQueryMethodObject(data))
	}
}