package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendAnimationMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendAnimationMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendAnimation(@NamedDelegate SendAnimationMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendAnimation(Map data) {
		sendAnimation(data as SendAnimationMethodObject)
	}
}