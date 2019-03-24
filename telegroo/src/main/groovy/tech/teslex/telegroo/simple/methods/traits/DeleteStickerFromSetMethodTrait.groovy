package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.DeleteStickerFromSetMethod
import tech.teslex.telegroo.telegram.methods.objects.DeleteStickerFromSetMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait DeleteStickerFromSetMethodTrait implements DeleteStickerFromSetMethod<TelegramResult<Object>> {

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
		DeleteStickerFromSetMethodObject builder = new DeleteStickerFromSetMethodObject()
		closure.delegate = builder
		closure.call()
		deleteStickerFromSet(builder)
	}
}
