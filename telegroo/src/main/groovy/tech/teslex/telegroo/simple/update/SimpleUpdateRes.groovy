package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.update.UpdateRes
import tech.teslex.telegroo.simple.SimpleTelegroo

@CompileStatic
class SimpleUpdateRes implements UpdateRes {

	private MethodsContext context

	private SimpleTelegroo telegroo

	SimpleUpdateRes(MethodsContext context, SimpleTelegroo telegroo) {
		this.context = context
		this.telegroo = telegroo
	}

	@Override
	MethodsContext getContext() {
		return this.context
	}

	@Override
	Telegroo getTelegroo() {
		this.telegroo
	}
}
