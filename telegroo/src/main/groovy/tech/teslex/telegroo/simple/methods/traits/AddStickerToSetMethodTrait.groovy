package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.AddStickerToSetMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.AddStickerToSetMethodObject

@CompileStatic
trait AddStickerToSetMethodTrait implements AddStickerToSetMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> addStickerToSet(@NamedDelegate AddStickerToSetMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> addStickerToSet(Map data) {
		addStickerToSet(data as AddStickerToSetMethodObject)
	}

	@Override
	TelegramResult<Object> addStickerToSet(@DelegatesTo(AddStickerToSetMethodObject) Closure closure) {
		def builder = AddStickerToSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		addStickerToSet(builder)
	}
}
