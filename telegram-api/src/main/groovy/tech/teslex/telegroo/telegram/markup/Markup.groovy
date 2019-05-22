package tech.teslex.telegroo.telegram.markup

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.types.ForceReply
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup
import tech.teslex.telegroo.telegram.types.ReplyKeyboardMarkup
import tech.teslex.telegroo.telegram.types.ReplyKeyboardRemove

@CompileStatic
class Markup {

	static final ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove()
	static final ForceReply forceReply = new ForceReply()

	static InlineKeyboardMarkup inlineKeyboard(@DelegatesTo(value = InlineKeyboardMarkupMaker, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineKeyboardMarkupMaker maker = new InlineKeyboardMarkupMaker()
		closure.delegate = maker
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		maker.markup
	}

	static ReplyKeyboardMarkup replyKeyboard(@DelegatesTo(value = ReplyKeyboardMarkupMaker, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		ReplyKeyboardMarkupMaker maker = new ReplyKeyboardMarkupMaker()
		closure.delegate = maker
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		maker.markup
	}

	static ReplyKeyboardRemove replyKeyboardRemove(@DelegatesTo(value = ReplyKeyboardRemove, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove()
		closure.delegate = replyKeyboardRemove
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		replyKeyboardRemove
	}

	static ForceReply forceReply(@DelegatesTo(value = ForceReply, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		ForceReply forceReply = new ForceReply()
		closure.delegate = forceReply
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		forceReply
	}
}