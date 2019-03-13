package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SendMediaGroupMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SendMediaGroupMethodTrait implements Context {

	@NamedVariant
	Message sendMediaGroup(@NamedDelegate SendMediaGroupMethodObject data) {
		data.chatId = data.chatId ?: lastUpdate[lastUpdate.updateType.type]['chat']['id']

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		(jacksonObjectMapper
				.readValue(api.go(data).returnContent().asStream(), type) as TelegramResult).result
	}

	Message sendMediaGroup(Map data) {
		sendMediaGroup(new SendMediaGroupMethodObject(data))
	}
}