package tech.teslex.telegroo.api.actions

trait GetFile {

	def getFile(fileId, Map params = [:]) {
		api.go('getFile', [file_id: fileId] + params)
	}
}
