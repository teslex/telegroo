package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendVideoNoteMethod
import tech.teslex.telegroo.telegram.methods.objects.SendVideoNoteMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendVideoNoteMethodTrait implements SendVideoNoteMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> sendVideoNote(@NamedDelegate SendVideoNoteMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendVideoNote(Map data) {
		sendVideoNote(data as SendVideoNoteMethodObject)
	}

	@Override
	TelegramResult<Message> sendVideoNote(@DelegatesTo(SendVideoNoteMethodObject) Closure closure) {
		SendVideoNoteMethodObject builder = new SendVideoNoteMethodObject()
		closure.delegate = builder
		closure.call()
		sendVideoNote(builder)
	}
}