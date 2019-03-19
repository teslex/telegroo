package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatAdministratorsMethodObject
import tech.teslex.telegroo.telegram.types.ChatMember

@CompileStatic
trait GetChatAdministratorsMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<List<ChatMember>> getChatAdministrators(@NamedDelegate GetChatAdministratorsMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, jacksonObjectMapper.typeFactory.constructCollectionLikeType(ArrayList, ChatMember))

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<List<ChatMember>> getChatAdministrators(Map data) {
		getChatAdministrators(data as GetChatAdministratorsMethodObject)
	}

	TelegramResult<List<ChatMember>> getChatAdministrators(@DelegatesTo(GetChatAdministratorsMethodObject) Closure closure) {
		def builder = GetChatAdministratorsMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChatAdministrators(builder)
	}
}