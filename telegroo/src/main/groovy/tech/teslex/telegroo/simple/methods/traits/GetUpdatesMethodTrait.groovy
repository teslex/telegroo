package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.GetUpdatesMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetUpdatesMethodObject
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
trait GetUpdatesMethodTrait implements GetUpdatesMethod<TelegramResult<List<Update>>>, ContextWithObjectMapper {

	@Override
	TelegramResult<List<Update>> getUpdates() {
		getUpdates(GetUpdatesMethodObject.newInstance())
	}

	@Override
	@NamedVariant
	TelegramResult<List<Update>> getUpdates(@NamedDelegate GetUpdatesMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, objectMapper.typeFactory.constructCollectionLikeType(ArrayList, Update))

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<List<Update>> getUpdates(Map data) {
		getUpdates(data as GetUpdatesMethodObject)
	}

	@Override
	TelegramResult<List<Update>> getUpdates(@DelegatesTo(GetUpdatesMethodObject) Closure closure) {
		def builder = GetUpdatesMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getUpdates(builder)
	}
}
