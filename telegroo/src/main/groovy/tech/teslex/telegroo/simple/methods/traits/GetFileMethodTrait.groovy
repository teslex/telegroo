package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.methods.GetFileMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
trait GetFileMethodTrait implements GetFileMethod<TelegramResult<FileObject>>, ContextWithObjectMapper {

	@Override
	@NamedVariant
	TelegramResult<FileObject> getFile(@NamedDelegate GetFileMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<FileObject> getFile(Map data) {
		getFile(data as GetFileMethodObject)
	}

	@Override
	TelegramResult<FileObject> getFile(@DelegatesTo(GetFileMethodObject) Closure closure) {
		def builder = GetFileMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getFile(builder)
	}
}
