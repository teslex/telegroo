package tech.teslex.telegroo.impl.res

import groovy.transform.CompileStatic
import tech.teslex.telegroo.SimpleTelegroo
import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.res.Res
import tech.teslex.telegroo.api.update.Update

import java.util.regex.Matcher

@CompileStatic
class SimpleRes implements Res {

	Update update

	Context context

	Matcher matcher

	SimpleTelegroo telegroo

	SimpleRes(Update update, Context context, Matcher matcher, SimpleTelegroo telegroo) {
		this.update = update
		this.context = context
		this.matcher = matcher
		this.telegroo = telegroo
	}

	SimpleRes(Update update, Context context, SimpleTelegroo telegroo) {
		this.update = update
		this.context = context
		this.telegroo = telegroo
	}

	@Override
	Update getUpdate() {
		return update
	}

	@Override
	Context getContext() {
		return context
	}

	@Override
	Matcher getMatcher() {
		return matcher
	}

	@Override
	Telegroo getTelegroo() {
		return telegroo
	}
}
