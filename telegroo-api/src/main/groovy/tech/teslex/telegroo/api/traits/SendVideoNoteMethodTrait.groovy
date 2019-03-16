package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendVideoNoteMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendVideoNoteMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVideoNoteMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendVideoNote(@NamedDelegate SendVideoNoteMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendVideoNote(Map data) {
		sendVideoNote(data as SendVideoNoteMethodObject)
	}

	TelegramResult<Message> sendVideoNote(@DelegatesTo(SendVideoNoteMethodObjectBuilder) Closure closure) {
		def builder = new SendVideoNoteMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendVideoNote(builder.build())
	}
}