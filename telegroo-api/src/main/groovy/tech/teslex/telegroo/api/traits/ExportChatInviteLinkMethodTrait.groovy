package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.ExportChatInviteLinkMethodObject

@CompileStatic
trait ExportChatInviteLinkMethodTrait implements Context {

	@NamedVariant
	TelegramResult<String> exportChatInviteLink(@NamedDelegate ExportChatInviteLinkMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, String)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<String> exportChatInviteLink(Map data) {
		exportChatInviteLink(new ExportChatInviteLinkMethodObject(data))
	}
}
