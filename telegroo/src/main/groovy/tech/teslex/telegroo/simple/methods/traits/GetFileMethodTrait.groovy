package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
trait GetFileMethodTrait implements Context<Response> {

	@NamedVariant
	TelegramResult<FileObject> getFile(@NamedDelegate GetFileMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<FileObject> getFile(Map data) {
		getFile(data as GetFileMethodObject)
	}

	TelegramResult<FileObject> getFile(@DelegatesTo(GetFileMethodObject) Closure closure) {
		def builder = GetFileMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getFile(builder)
	}
}
