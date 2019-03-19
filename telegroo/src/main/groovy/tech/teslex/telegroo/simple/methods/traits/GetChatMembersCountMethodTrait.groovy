package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetChatMembersCountMethodObject

@CompileStatic
trait GetChatMembersCountMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Integer> getChatMembersCount(@NamedDelegate GetChatMembersCountMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Integer)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Integer> getChatMembersCount(Map data) {
		getChatMembersCount(data as GetChatMembersCountMethodObject)
	}

	TelegramResult<Integer> getChatMembersCount(@DelegatesTo(GetChatMembersCountMethodObject) Closure closure) {
		def builder = GetChatMembersCountMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getChatMembersCount(builder)
	}
}
