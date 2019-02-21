package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait SendInvoice {

	def sendInvoice(title, description, payload, providerToken, startParameter, currency, prices, Map params = [:]) {
		api.go(new Some('sendInvoice', [
				chat_id        : lastUpdate.updateData[lastUpdate.updateType].chat.id,
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
