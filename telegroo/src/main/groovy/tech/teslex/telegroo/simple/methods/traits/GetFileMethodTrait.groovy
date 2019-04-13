package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.GetFileMethod
import tech.teslex.telegroo.telegram.methods.objects.GetFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetFileMethodTrait implements GetFileMethod<TelegramResult<FileObject>> {

	@Override
	@NamedVariant
	TelegramResult<FileObject> getFile(@NamedDelegate GetFileMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<FileObject> getFile(Map data) {
		getFile(data as GetFileMethodObject)
	}

	@Override
	TelegramResult<FileObject> getFile(@DelegatesTo(GetFileMethodObject) Closure closure) {
		GetFileMethodObject builder = new GetFileMethodObject()
		closure.delegate = builder
		closure.call()
		getFile(builder)
	}
}
