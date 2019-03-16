package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.DeleteStickerFromSetMethodObject

@CompileStatic
trait DeleteStickerFromSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> deleteStickerFromSet(@NamedDelegate DeleteStickerFromSetMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> deleteStickerFromSet(Map data) {
		deleteStickerFromSet(data as DeleteStickerFromSetMethodObject)
	}

	TelegramResult<Object> deleteStickerFromSet(@DelegatesTo(DeleteStickerFromSetMethodObject) Closure closure) {
		def builder = DeleteStickerFromSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		deleteStickerFromSet(builder)
	}
}
