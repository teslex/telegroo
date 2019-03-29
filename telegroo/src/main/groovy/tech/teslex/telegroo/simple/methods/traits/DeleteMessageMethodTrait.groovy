package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.DeleteMessageMethod
import tech.teslex.telegroo.telegram.methods.objects.DeleteMessageMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait DeleteMessageMethodTrait implements DeleteMessageMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteMessage(@NamedDelegate DeleteMessageMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']
		data.messageId = data.messageId ?: update[update.updateType.value]['messageId'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> deleteMessage(Map data) {
		deleteMessage(data as DeleteMessageMethodObject)
	}

	@Override
	TelegramResult<Object> deleteMessage(@DelegatesTo(DeleteMessageMethodObject) Closure closure) {
		DeleteMessageMethodObject builder = new DeleteMessageMethodObject()
		closure.delegate = builder
		closure.call()
		deleteMessage(builder)
	}
}
