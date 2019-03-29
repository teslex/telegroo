package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.DeleteChatPhotoMethod
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatPhotoMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait DeleteChatPhotoMethodTrait implements DeleteChatPhotoMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteChatPhoto(@NamedDelegate DeleteChatPhotoMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> deleteChatPhoto(Map data) {
		deleteChatPhoto(data as DeleteChatPhotoMethodObject)
	}

	@Override
	TelegramResult<Object> deleteChatPhoto(@DelegatesTo(DeleteChatPhotoMethodObject) Closure closure) {
		DeleteChatPhotoMethodObject builder = new DeleteChatPhotoMethodObject()
		closure.delegate = builder
		closure.call()
		deleteChatPhoto(builder)
	}
}
