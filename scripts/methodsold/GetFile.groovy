package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.FileObject

@CompileStatic
trait GetFile extends AbstractContext {

	FileObject getFile(fileId, Map params = [:]) {
		def result = api.go(new Some('getFile', [file_id: fileId] + params))['result'] as Map
		return m2c2m(result, FileObject) as FileObject
	}
}
