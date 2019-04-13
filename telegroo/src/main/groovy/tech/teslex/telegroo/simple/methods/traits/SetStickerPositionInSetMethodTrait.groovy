package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.SetStickerPositionInSetMethod
import tech.teslex.telegroo.telegram.methods.objects.SetStickerPositionInSetMethodObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait SetStickerPositionInSetMethodTrait implements SetStickerPositionInSetMethod<TelegramResult<Object>> {

	@Override
	@NamedVariant
	TelegramResult<Object> setStickerPositionInSet(@NamedDelegate SetStickerPositionInSetMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Object)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setStickerPositionInSet(Map data) {
		setStickerPositionInSet(data as SetStickerPositionInSetMethodObject)
	}

	@Override
	TelegramResult<Object> setStickerPositionInSet(@DelegatesTo(SetStickerPositionInSetMethodObject) Closure closure) {
		SetStickerPositionInSetMethodObject builder = new SetStickerPositionInSetMethodObject()
		closure.delegate = builder
		closure.call()
		setStickerPositionInSet(builder)
	}
}
