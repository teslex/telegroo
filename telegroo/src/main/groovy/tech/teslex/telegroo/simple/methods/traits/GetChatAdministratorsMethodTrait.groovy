package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.GetChatAdministratorsMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatAdministratorsMethodObject
import tech.teslex.telegroo.telegram.types.ChatMember

@CompileStatic
trait GetChatAdministratorsMethodTrait implements GetChatAdministratorsMethod<TelegramResult<List<ChatMember>>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<List<ChatMember>> getChatAdministrators(@NamedDelegate GetChatAdministratorsMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, objectMapper.typeFactory.constructCollectionLikeType(ArrayList, ChatMember))

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<List<ChatMember>> getChatAdministrators(Map data) {
		getChatAdministrators(data as GetChatAdministratorsMethodObject)
	}

	@Override
	TelegramResult<List<ChatMember>> getChatAdministrators(@DelegatesTo(GetChatAdministratorsMethodObject) Closure closure) {
		def builder = GetChatAdministratorsMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChatAdministrators(builder)
	}
}