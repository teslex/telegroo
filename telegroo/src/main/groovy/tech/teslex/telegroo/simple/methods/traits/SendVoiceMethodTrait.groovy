package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.SendVoiceMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendVoiceMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVoiceMethodTrait implements SendVoiceMethod<TelegramResult<Message>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Message> sendVoice(@NamedDelegate SendVoiceMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendVoice(Map data) {
		sendVoice(data as SendVoiceMethodObject)
	}

	@Override
	TelegramResult<Message> sendVoice(@DelegatesTo(SendVoiceMethodObject) Closure closure) {
		def builder = SendVoiceMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		sendVoice(builder)
	}
}