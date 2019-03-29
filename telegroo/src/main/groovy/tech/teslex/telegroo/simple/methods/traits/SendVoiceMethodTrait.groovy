package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendVoiceMethod
import tech.teslex.telegroo.telegram.methods.objects.SendVoiceMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendVoiceMethodTrait implements SendVoiceMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> sendVoice(@NamedDelegate SendVoiceMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendVoice(Map data) {
		sendVoice(data as SendVoiceMethodObject)
	}

	@Override
	TelegramResult<Message> sendVoice(@DelegatesTo(SendVoiceMethodObject) Closure closure) {
		SendVoiceMethodObject builder = new SendVoiceMethodObject()
		closure.delegate = builder
		closure.call()
		sendVoice(builder)
	}
}