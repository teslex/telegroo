package tech.teslex.telegroo.simple.methods.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.payments.SendInvoiceMethod
import tech.teslex.telegroo.telegram.methods.objects.payments.SendInvoiceMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendInvoiceMethodTrait implements SendInvoiceMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendInvoice(@NamedDelegate SendInvoiceMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendInvoice(Map data) {
		sendInvoice(data as SendInvoiceMethodObject)
	}

	@Override
	TelegramResult<Message> sendInvoice(@DelegatesTo(SendInvoiceMethodObject) Closure closure) {
		def builder = SendInvoiceMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendInvoice(builder)
	}
}
