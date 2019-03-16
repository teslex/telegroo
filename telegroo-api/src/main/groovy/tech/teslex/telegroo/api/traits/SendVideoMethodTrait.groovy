package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SendVideoMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SendVideoMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendVideoMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Message> sendVideo(@NamedDelegate SendVideoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Message> sendVideo(Map data) {
		sendVideo(data as SendVideoMethodObject)
	}

	TelegramResult<Message> sendVideo(@DelegatesTo(SendVideoMethodObjectBuilder) Closure closure) {
		def builder = new SendVideoMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		sendVideo(builder.build())
	}
}