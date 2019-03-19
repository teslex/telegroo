package tech.teslex.telegroo.simple.context

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.simple.methods.MethodsTraits

@CompileStatic
interface MethodsContext extends Context<Response>, MethodsTraits {
}