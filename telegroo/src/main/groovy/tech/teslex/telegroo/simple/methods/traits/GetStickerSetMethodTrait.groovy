package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.GetStickerSetMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetStickerSetMethodObject
import tech.teslex.telegroo.telegram.types.stickers.StickerSet

@CompileStatic
trait GetStickerSetMethodTrait implements GetStickerSetMethod<TelegramResult<StickerSet>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<StickerSet> getStickerSet(@NamedDelegate GetStickerSetMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, StickerSet)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<StickerSet> getStickerSet(Map data) {
		getStickerSet(data as GetStickerSetMethodObject)
	}

	@Override
	TelegramResult<StickerSet> getStickerSet(@DelegatesTo(GetStickerSetMethodObject) Closure closure) {
		def builder = GetStickerSetMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getStickerSet(builder)
	}
}