package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.UpdateRes

@CompileStatic
interface UpdateHandler {

	void handle(UpdateRes res)
}