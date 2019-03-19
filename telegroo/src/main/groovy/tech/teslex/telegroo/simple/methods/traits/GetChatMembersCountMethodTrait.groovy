package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.GetChatMembersCountMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMembersCountMethodObject

@CompileStatic
trait GetChatMembersCountMethodTrait implements GetChatMembersCountMethod<TelegramResult<Integer>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Integer> getChatMembersCount(@NamedDelegate GetChatMembersCountMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Integer)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Integer> getChatMembersCount(Map data) {
		getChatMembersCount(data as GetChatMembersCountMethodObject)
	}

	@Override
	TelegramResult<Integer> getChatMembersCount(@DelegatesTo(GetChatMembersCountMethodObject) Closure closure) {
		def builder = GetChatMembersCountMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChatMembersCount(builder)
	}
}
