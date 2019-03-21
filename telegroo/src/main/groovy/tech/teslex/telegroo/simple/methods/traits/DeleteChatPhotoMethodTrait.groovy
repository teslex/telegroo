package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.DeleteChatPhotoMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatPhotoMethodObject

@CompileStatic
trait DeleteChatPhotoMethodTrait implements DeleteChatPhotoMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteChatPhoto(@NamedDelegate DeleteChatPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> deleteChatPhoto(Map data) {
		deleteChatPhoto(data as DeleteChatPhotoMethodObject)
	}

	@Override
	TelegramResult<Object> deleteChatPhoto(@DelegatesTo(DeleteChatPhotoMethodObject) Closure closure) {
		def builder = DeleteChatPhotoMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		deleteChatPhoto(builder)
	}
}
