package tech.teslex.telegroo.telegram.markup

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.api.types.KeyboardButton
import tech.teslex.telegroo.telegram.api.types.ReplyKeyboardMarkup

@CompileStatic
class ReplyKeyboardMarkupMaker {

	private final ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard: [])

	void row(@DelegatesTo(value = ReplyKeyboardRow, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		ReplyKeyboardRow row = new ReplyKeyboardRow()
		closure.delegate = row
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		markup.keyboard.add(row.buttons)
	}

	ReplyKeyboardMarkup getMarkup() {
		this.markup
	}
}

@CompileStatic
class ReplyKeyboardRow {

	private final List<KeyboardButton> buttons = []

	void button(@DelegatesTo(value = KeyboardButton, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		KeyboardButton button = new KeyboardButton()
		closure.delegate = button
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		buttons << button
	}

	@NamedVariant
	void button(@NamedDelegate KeyboardButton button) {
		buttons << button
	}

	List<KeyboardButton> getButtons() {
		this.buttons
	}
}