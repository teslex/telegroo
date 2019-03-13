package tech.teslex.telegroo.api.context

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
interface Context {

	Api getApi()

	Update getLastUpdate()

	ObjectMapper getJacksonObjectMapper()
}
