package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.UploadStickerFileMethod
import tech.teslex.telegroo.telegram.methods.objects.UploadStickerFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait UploadStickerFileMethodTrait implements UploadStickerFileMethod<TelegramResult<FileObject>> {

	@Override
	@NamedVariant
	TelegramResult<FileObject> uploadStickerFile(@NamedDelegate UploadStickerFileMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<FileObject> uploadStickerFile(Map data) {
		uploadStickerFile(data as UploadStickerFileMethodObject)
	}

	@Override
	TelegramResult<FileObject> uploadStickerFile(@DelegatesTo(UploadStickerFileMethodObject) Closure closure) {
		UploadStickerFileMethodObject builder = new UploadStickerFileMethodObject()
		closure.delegate = builder
		closure.call()
		uploadStickerFile(builder)
	}
}
