package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.SetChatPhotoMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetChatPhotoMethodObject

@CompileStatic
trait SetChatPhotoMethodTrait implements SetChatPhotoMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> setChatPhoto(@NamedDelegate SetChatPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setChatPhoto(Map data) {
		setChatPhoto(data as SetChatPhotoMethodObject)
	}

	@Override
	TelegramResult<Object> setChatPhoto(@DelegatesTo(SetChatPhotoMethodObject) Closure closure) {
		def builder = SetChatPhotoMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setChatPhoto(builder)
	}
}
