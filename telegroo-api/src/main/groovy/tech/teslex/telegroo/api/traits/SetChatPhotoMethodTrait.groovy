package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.SetChatPhotoMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.SetChatPhotoMethodObject

@CompileStatic
trait SetChatPhotoMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> setChatPhoto(@NamedDelegate SetChatPhotoMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setChatPhoto(Map data) {
		setChatPhoto(data as SetChatPhotoMethodObject)
	}

	TelegramResult<Object> setChatPhoto(@DelegatesTo(SetChatPhotoMethodObjectBuilder) Closure closure) {
		def builder = new SetChatPhotoMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		setChatPhoto(builder.build())
	}
}