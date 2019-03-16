package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.DeleteMessageMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.DeleteMessageMethodObject

@CompileStatic
trait DeleteMessageMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> deleteMessage(@NamedDelegate DeleteMessageMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']
		data.messageId = data.messageId ?: lastUpdate[lastUpdate.updateType.type]['messageId'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> deleteMessage(Map data) {
		deleteMessage(data as DeleteMessageMethodObject)
	}

	TelegramResult<Object> deleteMessage(@DelegatesTo(DeleteMessageMethodObjectBuilder) Closure closure) {
		def builder = new DeleteMessageMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		deleteMessage(builder.build())
	}
}