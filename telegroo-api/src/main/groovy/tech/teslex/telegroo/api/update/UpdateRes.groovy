package tech.teslex.telegroo.api.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
interface UpdateRes {

	Update getUpdate()

	MethodsContext getContext()

	Matcher getMatcher()

	Telegroo getTelegroo()
}
