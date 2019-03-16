package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.AddStickerToSetMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.AddStickerToSetMethodObject

@CompileStatic
trait AddStickerToSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> addStickerToSet(@NamedDelegate AddStickerToSetMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> addStickerToSet(Map data) {
		addStickerToSet(data as AddStickerToSetMethodObject)
	}

	TelegramResult<Object> addStickerToSet(@DelegatesTo(AddStickerToSetMethodObjectBuilder) Closure closure) {
		def builder = new AddStickerToSetMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		addStickerToSet(builder.build())
	}
}
