package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.ExportChatInviteLinkMethodObject

@CompileStatic
trait ExportChatInviteLinkMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<String> exportChatInviteLink(@NamedDelegate ExportChatInviteLinkMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, String)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<String> exportChatInviteLink(Map data) {
		exportChatInviteLink(data as ExportChatInviteLinkMethodObject)
	}

	TelegramResult<String> exportChatInviteLink(@DelegatesTo(ExportChatInviteLinkMethodObject) Closure closure) {
		def builder = ExportChatInviteLinkMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		exportChatInviteLink(builder)
	}
}
