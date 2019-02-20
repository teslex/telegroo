package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.update.Update
import tech.teslex.telegroo.api.update.UpdateRes
import tech.teslex.telegroo.simple.SimpleTelegroo

import java.util.regex.Matcher

@CompileStatic
class SimpleUpdateRes implements UpdateRes {

	Update update

	Context context

	Matcher matcher

	SimpleTelegroo telegroo

	SimpleUpdateRes(Update update, Context context, Matcher matcher, SimpleTelegroo telegroo) {
		this.update = update
		this.context = context
		this.matcher = matcher
		this.telegroo = telegroo
	}

	SimpleUpdateRes(Update update, Context context, SimpleTelegroo telegroo) {
		this.update = update
		this.context = context
		this.telegroo = telegroo
	}
}
