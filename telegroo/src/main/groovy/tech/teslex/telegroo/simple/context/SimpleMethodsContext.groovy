package tech.teslex.telegroo.simple.context

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.simple.methods.MethodsTraits

@CompileStatic
interface SimpleMethodsContext extends MethodsContext<Response>, ContextWithObjectMapper, MethodsTraits {}