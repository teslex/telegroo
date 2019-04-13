package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.ExportChatInviteLinkMethod
import tech.teslex.telegroo.telegram.methods.objects.ExportChatInviteLinkMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait ExportChatInviteLinkMethodTrait implements ExportChatInviteLinkMethod<TelegramResult<String>> {

	@Override
	@NamedVariant
	TelegramResult<String> exportChatInviteLink(@NamedDelegate ExportChatInviteLinkMethodObject data) {
		data.chatId = data.chatId ?: update[update.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, String)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<String> exportChatInviteLink(Map data) {
		exportChatInviteLink(data as ExportChatInviteLinkMethodObject)
	}

	@Override
	TelegramResult<String> exportChatInviteLink(@DelegatesTo(ExportChatInviteLinkMethodObject) Closure closure) {
		ExportChatInviteLinkMethodObject builder = new ExportChatInviteLinkMethodObject()
		closure.delegate = builder
		closure.call()
		exportChatInviteLink(builder)
	}
}
