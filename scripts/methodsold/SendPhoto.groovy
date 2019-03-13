package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.some.SomePhoto
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendPhoto extends AbstractContext {

	Message sendPhoto(File photo, String caption = '', Map params = [:]) {
		sendPhoto(photo, caption, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendPhoto(String photo, String caption = '', Map params = [:]) {
		sendPhoto(photo, caption, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendPhotoId(String photoId, String caption = '', Map params = [:]) {
		sendPhotoId(photoId, caption, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	Message sendPhoto(File photo, String caption = '', chatId, Map params = [:]) {
		def result = api.go(new SomePhoto(caption, photo, [chat_id: chatId] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendPhoto(String photo, String caption = '', chatId, Map params = [:]) {
		if (caption)
			params += [caption: caption]

		def result = api.go(new Some('sendPhoto', [chat_id: chatId, photo: photo] + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}

	Message sendPhotoId(String photoId, String caption = '', chatId, Map params = [:]) {
		if (caption)
			params += [caption: caption]

		def result = api.go(new Some('sendPhoto', ([chat_id: chatId, photo: [file_id: photoId]] as Map) + params))['result'] as Map
		return m2c2m(result, Message) as Message
	}
}