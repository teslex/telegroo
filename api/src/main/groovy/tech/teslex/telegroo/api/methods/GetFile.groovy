package tech.teslex.telegroo.api.methods

import tech.teslex.telegroo.api.some.Some

trait GetFile {

	def getFile(fileId, Map params = [:]) {
		api.go(new Some('getFile', [file_id: fileId] + params))
	}
}
