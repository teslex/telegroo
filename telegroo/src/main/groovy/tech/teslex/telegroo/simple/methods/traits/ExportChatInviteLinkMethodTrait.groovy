package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.ExportChatInviteLinkMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.ExportChatInviteLinkMethodObject

@CompileStatic
trait ExportChatInviteLinkMethodTrait implements ExportChatInviteLinkMethod<TelegramResult<String>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<String> exportChatInviteLink(@NamedDelegate ExportChatInviteLinkMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.value]['chat']['id']

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, String)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<String> exportChatInviteLink(Map data) {
		exportChatInviteLink(data as ExportChatInviteLinkMethodObject)
	}

	@Override
	TelegramResult<String> exportChatInviteLink(@DelegatesTo(ExportChatInviteLinkMethodObject) Closure closure) {
		def builder = ExportChatInviteLinkMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		exportChatInviteLink(builder)
	}
}
