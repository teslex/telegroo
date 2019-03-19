package tech.teslex.telegroo.simple.context

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context

@CompileStatic
interface ContextWithObjectMapper extends Context<Response> {

	ObjectMapper getObjectMapper()
}
