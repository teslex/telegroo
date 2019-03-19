package tech.teslex.telegroo.simple.context

import groovy.transform.CompileStatic
import tech.teslex.telegroo.simple.methods.MethodsTraits

@CompileStatic
interface MethodsContext extends ContextWithObjectMapper, MethodsTraits {}