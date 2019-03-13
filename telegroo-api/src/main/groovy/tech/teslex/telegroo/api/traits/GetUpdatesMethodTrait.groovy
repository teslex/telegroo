package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.TelegramResult
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.methods.objects.GetUpdatesMethodObject
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
trait GetUpdatesMethodTrait implements Context {

	List<Update> getUpdates() {
		getUpdates(new GetUpdatesMethodObject())
	}

	@NamedVariant
	List<Update> getUpdates(@NamedDelegate GetUpdatesMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, jacksonObjectMapper.typeFactory.constructCollectionLikeType(ArrayList, Update))

		(jacksonObjectMapper
				.readValue(api.go(data).returnContent().asStream(), type) as TelegramResult).result
	}

	List<Update> getUpdates(Map data) {
		getUpdates(new GetUpdatesMethodObject(data))
	}
}
