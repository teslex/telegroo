package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic

@CompileStatic
interface UpdateHandler {

	void handle(UpdateRes res)
}