package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SendVenueMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendVenueMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVenueMethodTrait implements SendVenueMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendVenue(@NamedDelegate SendVenueMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendVenue(Map data) {
		sendVenue(data as SendVenueMethodObject)
	}

	@Override
	TelegramResult<Message> sendVenue(@DelegatesTo(SendVenueMethodObject) Closure closure) {
		def builder = SendVenueMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendVenue(builder)
	}
}
