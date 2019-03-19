package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.DeleteStickerFromSetMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.DeleteStickerFromSetMethodObject

@CompileStatic
trait DeleteStickerFromSetMethodTrait implements DeleteStickerFromSetMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<Object> deleteStickerFromSet(@NamedDelegate DeleteStickerFromSetMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> deleteStickerFromSet(Map data) {
		deleteStickerFromSet(data as DeleteStickerFromSetMethodObject)
	}

	@Override
	TelegramResult<Object> deleteStickerFromSet(@DelegatesTo(DeleteStickerFromSetMethodObject) Closure closure) {
		def builder = DeleteStickerFromSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		deleteStickerFromSet(builder)
	}
}
