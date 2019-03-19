package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.CreateNewStickerSetMethodObject

@CompileStatic
trait CreateNewStickerSetMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<Object> createNewStickerSet(@NamedDelegate CreateNewStickerSetMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> createNewStickerSet(Map data) {
		createNewStickerSet(data as CreateNewStickerSetMethodObject)
	}

	TelegramResult<Object> createNewStickerSet(@DelegatesTo(CreateNewStickerSetMethodObject) Closure closure) {
		def builder = CreateNewStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		createNewStickerSet(builder)
	}
}
