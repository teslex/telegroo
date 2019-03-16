package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.DeleteChatPhotoMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.DeleteChatPhotoMethodObject

@CompileStatic
trait DeleteChatPhotoMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> deleteChatPhoto(@NamedDelegate DeleteChatPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> deleteChatPhoto(Map data) {
		deleteChatPhoto(data as DeleteChatPhotoMethodObject)
	}

	TelegramResult<Object> deleteChatPhoto(@DelegatesTo(DeleteChatPhotoMethodObjectBuilder) Closure closure) {
		def builder = new DeleteChatPhotoMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		deleteChatPhoto(builder.build())
	}
}