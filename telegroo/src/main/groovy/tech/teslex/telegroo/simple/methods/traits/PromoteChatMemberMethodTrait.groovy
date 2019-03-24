package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.PromoteChatMemberMethod
import tech.teslex.telegroo.telegram.methods.objects.PromoteChatMemberMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait PromoteChatMemberMethodTrait implements PromoteChatMemberMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> promoteChatMember(@NamedDelegate PromoteChatMemberMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> promoteChatMember(Map data) {
		promoteChatMember(data as PromoteChatMemberMethodObject)
	}

	@Override
	TelegramResult<Object> promoteChatMember(@DelegatesTo(PromoteChatMemberMethodObject) Closure closure) {
		PromoteChatMemberMethodObject builder = new PromoteChatMemberMethodObject()
		closure.delegate = builder
		closure.call()
		promoteChatMember(builder)
	}
}
