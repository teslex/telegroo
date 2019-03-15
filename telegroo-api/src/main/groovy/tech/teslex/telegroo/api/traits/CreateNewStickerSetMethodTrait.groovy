package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.CreateNewStickerSetMethodObject

@CompileStatic
trait CreateNewStickerSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> createNewStickerSet(@NamedDelegate CreateNewStickerSetMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> createNewStickerSet(Map data) {
		createNewStickerSet(data as CreateNewStickerSetMethodObject)
	}
}
