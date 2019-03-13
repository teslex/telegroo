package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.SomeFile
import tech.teslex.telegroo.api.telegram.some.SomeMediaGroup
import tech.teslex.telegroo.api.telegram.types.Message

@CompileStatic
trait SendMediaGroup extends AbstractContext {

	List<Message> sendMediaGroup(List<SomeFile> media, Map params = [:]) {
		sendMediaGroup(media, lastUpdate.updateData[lastUpdate.updateType.type]['chat']['id'], params)
	}

	List<Message> sendMediaGroup(List<SomeFile> media, chatId, Map params = [:]) {
		def result = api.go(new SomeMediaGroup(media, [chat_id: chatId] + params))['result'] as List<Map>

		return result.collect { m2c2m(it, Message) as Message }
	}

	List<Message> sendMediaGroupMap(List<Map> media, chatId, Map params = [:]) {
		def result = api.goWithMediaGroup('sendMediaGroup', media, [chat_id: chatId] + params)['result'] as List<Map>

		return result.collect { m2c2m(it, Message) as Message }
	}
}
