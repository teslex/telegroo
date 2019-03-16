package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.UploadStickerFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
trait UploadStickerFileMethodTrait implements Context {

	@NamedVariant
	TelegramResult<FileObject> uploadStickerFile(@NamedDelegate UploadStickerFileMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<FileObject> uploadStickerFile(Map data) {
		uploadStickerFile(data as UploadStickerFileMethodObject)
	}

	TelegramResult<FileObject> uploadStickerFile(@DelegatesTo(UploadStickerFileMethodObject) Closure closure) {
		def builder = UploadStickerFileMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		uploadStickerFile(builder)
	}
}
