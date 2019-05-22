package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.api.methods.reply.WithMethodObject
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.MethodObject

@CompileStatic
@SelfType(SimpleContext)
trait WithMethodObjectTrait implements WithMethodObject {

	@Override
	<T extends MethodObject> TelegramResult<Object> withMethodObject(Class<T> type, @DelegatesTo(type = "T") Closure closure) {
		T t = type.newInstance()
		closure.delegate = t
		closure()
		withMethodObject(t)
	}

	TelegramResult<Object> withMethodObject(MethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)
		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}
}