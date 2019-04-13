package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.GetChatMembersCountMethod
import tech.teslex.telegroo.telegram.methods.objects.GetChatMembersCountMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetChatMembersCountMethodTrait implements GetChatMembersCountMethod<TelegramResult<Integer>> {

	@Override
	@NamedVariant
	TelegramResult<Integer> getChatMembersCount(@NamedDelegate GetChatMembersCountMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Integer)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Integer> getChatMembersCount(Map data) {
		getChatMembersCount(data as GetChatMembersCountMethodObject)
	}

	@Override
	TelegramResult<Integer> getChatMembersCount(@DelegatesTo(GetChatMembersCountMethodObject) Closure closure) {
		GetChatMembersCountMethodObject builder = new GetChatMembersCountMethodObject()
		closure.delegate = builder
		closure.call()
		getChatMembersCount(builder)
	}
}
