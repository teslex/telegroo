package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendVenueMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVenueMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendVenue(@NamedDelegate SendVenueMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendVenue(Map data) {
		sendVenue(data as SendVenueMethodObject)
	}

	TelegramResult<Message> sendVenue(@DelegatesTo(SendVenueMethodObject) Closure closure) {
		def builder = SendVenueMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendVenue(builder)
	}
}
