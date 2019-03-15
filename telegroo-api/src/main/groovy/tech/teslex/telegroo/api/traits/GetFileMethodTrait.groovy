package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
trait GetFileMethodTrait implements Context {

	@NamedVariant
	TelegramResult<FileObject> getFile(@NamedDelegate GetFileMethodObject data) {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<FileObject> getFile(Map data) {
		getFile(data as GetFileMethodObject)
	}
}
