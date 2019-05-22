package tech.teslex.telegroo.telegram.markup

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.types.InlineKeyboardButton
import tech.teslex.telegroo.telegram.types.InlineKeyboardMarkup

@CompileStatic
class InlineKeyboardMarkupMaker {

	private final InlineKeyboardMarkup markup = new InlineKeyboardMarkup(inlineKeyboard: [])

	void row(@DelegatesTo(value = InlineKeyboardRow, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineKeyboardRow row = new InlineKeyboardRow()
		closure.delegate = row
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		markup.inlineKeyboard.add(row.buttons)
	}

	InlineKeyboardMarkup getMarkup() {
		this.markup
	}
}

@CompileStatic
class InlineKeyboardRow {

	private final List<InlineKeyboardButton> buttons = []

	void button(@DelegatesTo(value = InlineKeyboardButton, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineKeyboardButton button = new InlineKeyboardButton()
		closure.delegate = button
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		buttons << button
	}

	@NamedVariant
	void button(@NamedDelegate InlineKeyboardButton button) {
		buttons << button
	}

	List<InlineKeyboardButton> getButtons() {
		this.buttons
	}
}