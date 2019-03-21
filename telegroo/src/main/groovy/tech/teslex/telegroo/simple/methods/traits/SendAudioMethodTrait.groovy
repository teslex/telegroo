package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SendAudioMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendAudioMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendAudioMethodTrait implements SendAudioMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendAudio(@NamedDelegate SendAudioMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendAudio(Map data) {
		sendAudio(data as SendAudioMethodObject)
	}

	@Override
	TelegramResult<Message> sendAudio(@DelegatesTo(SendAudioMethodObject) Closure closure) {
		def builder = SendAudioMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendAudio(builder)
	}
}