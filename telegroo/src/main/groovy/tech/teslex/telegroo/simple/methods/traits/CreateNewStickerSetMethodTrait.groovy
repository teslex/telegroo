package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.CreateNewStickerSetMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.CreateNewStickerSetMethodObject

@CompileStatic
trait CreateNewStickerSetMethodTrait implements CreateNewStickerSetMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> createNewStickerSet(@NamedDelegate CreateNewStickerSetMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> createNewStickerSet(Map data) {
		createNewStickerSet(data as CreateNewStickerSetMethodObject)
	}

	@Override
	TelegramResult<Object> createNewStickerSet(@DelegatesTo(CreateNewStickerSetMethodObject) Closure closure) {
		def builder = CreateNewStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		createNewStickerSet(builder)
	}
}
