package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SendAnimationMethod
import tech.teslex.telegroo.telegram.methods.objects.SendAnimationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SendAnimationMethodTrait implements SendAnimationMethod<TelegramResult<Message>> {

	@Override
	@NamedVariant
	TelegramResult<Message> sendAnimation(@NamedDelegate SendAnimationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Message> sendAnimation(Map data) {
		sendAnimation(data as SendAnimationMethodObject)
	}

	@Override
	TelegramResult<Message> sendAnimation(@DelegatesTo(SendAnimationMethodObject) Closure closure) {
		SendAnimationMethodObject builder = new SendAnimationMethodObject()
		closure.delegate = builder
		closure.call()
		sendAnimation(builder)
	}
}