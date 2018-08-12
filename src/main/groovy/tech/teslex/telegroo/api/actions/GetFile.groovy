package tech.teslex.telegroo.api.actions

import tech.teslex.telegroo.api.req.Some

trait GetFile {

	def getFile(fileId, Map params = [:]) {
		api.go(new Some('getFile', [file_id: fileId] + params))
	}
}
