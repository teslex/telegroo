package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetStickerSetMethodObject
import tech.teslex.telegroo.telegram.types.stickers.StickerSet

@CompileStatic
trait GetStickerSetMethodTrait implements Context {

	@NamedVariant
	TelegramResult<StickerSet> getStickerSet(@NamedDelegate GetStickerSetMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, StickerSet)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<StickerSet> getStickerSet(Map data) {
		getStickerSet(data as GetStickerSetMethodObject)
	}

	TelegramResult<StickerSet> getStickerSet(@DelegatesTo(GetStickerSetMethodObject) Closure closure) {
		def builder = GetStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getStickerSet(builder)
	}
}
