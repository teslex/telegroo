package tech.teslex.telegroo.api.context

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
interface Context<T> extends Cloneable {

	Api<T> getApi()

	void setApi(Api api)

	Update getLastUpdate()

	Matcher getMatcher()

	Context createNewContext(Api api, Update update, Matcher matcher)
}