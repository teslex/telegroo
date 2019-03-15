package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.SetStickerPositionInSetMethodObject

@CompileStatic
trait SetStickerPositionInSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<Object> setStickerPositionInSet(@NamedDelegate SetStickerPositionInSetMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<Object> setStickerPositionInSet(Map data) {
		setStickerPositionInSet(new SetStickerPositionInSetMethodObject(data))
	}
}
