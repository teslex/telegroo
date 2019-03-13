package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some

@CompileStatic
trait SendInvoice extends AbstractContext {

	def sendInvoice(title, description, payload, providerToken, startParameter, currency, prices, Map params = [:]) {
		api.go(new Some('sendInvoice', [
				chat_id        : lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'],
				title          : title,
				description    : description,
				payload        : payload,
				provider_token : providerToken,
				start_parameter: startParameter,
				currency       : currency,
				prices         : prices
		] + params))
	}

	def sendInvoice(chatId, title, description, payload, providerToken, startParameter, currency, prices, Map params = [:]) {
		api.go(new Some('sendInvoice', [
				chat_id        : chatId,
				title          : title,
				description    : description,
				payload        : payload,
				provider_token : providerToken,
				start_parameter: startParameter,
				currency       : currency,
				prices         : prices
		] + params))
	}
}
