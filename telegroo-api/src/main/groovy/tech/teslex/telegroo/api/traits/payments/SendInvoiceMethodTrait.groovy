package tech.teslex.telegroo.api.traits.payments

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.payments.SendInvoiceMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendInvoiceMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendInvoice(@NamedDelegate SendInvoiceMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendInvoice(Map data) {
		sendInvoice(data as SendInvoiceMethodObject)
	}
}
