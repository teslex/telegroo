package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.UpdateRes
import tech.teslex.telegroo.simple.SimpleTelegroo
import tech.teslex.telegroo.telegram.types.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleUpdateRes implements UpdateRes {

	private Update update

	private MethodsContext context

	private Matcher matcher

	private SimpleTelegroo telegroo

	SimpleUpdateRes(Update update, MethodsContext context, Matcher matcher, SimpleTelegroo telegroo) {
		this.update = update
		this.context = context
		this.matcher = matcher
		this.telegroo = telegroo
	}

	SimpleUpdateRes(Update update, MethodsContext context, SimpleTelegroo telegroo) {
		this.update = update
		this.context = context
		this.telegroo = telegroo
	}

	@Override
	Update getUpdate() {
		this.update
	}

	@Override
	MethodsContext getContext() {
		return this.context
	}

	@Override
	Matcher getMatcher() {
		this.matcher
	}

	@Override
	Telegroo getTelegroo() {
		this.telegroo
	}
}
