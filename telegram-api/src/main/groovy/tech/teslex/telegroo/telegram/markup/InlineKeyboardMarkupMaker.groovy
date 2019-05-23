package tech.teslex.telegroo.telegram.markup

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardButton
import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup
import tech.teslex.telegroo.telegram.api.types.games.CallbackGame

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

	void callbackButton(String text, String callbackData) {
		buttons << new InlineKeyboardButton(text: text, callbackData: callbackData)
	}

	void urlButton(String text, String url) {
		buttons << new InlineKeyboardButton(text: text, url: url)
	}

	void switchInlineQueryButton(String text, String switchInlineQuery) {
		buttons << new InlineKeyboardButton(text: text, switchInlineQuery: switchInlineQuery)
	}

	void switchInlineQueryCurrentChatButton(String text, String switchInlineQueryCurrentChat) {
		buttons << new InlineKeyboardButton(text: text, switchInlineQueryCurrentChat: switchInlineQueryCurrentChat)
	}

	void callbackGameButton(String text, CallbackGame callbackGame = new CallbackGame()) {
		buttons << new InlineKeyboardButton(text: text, callbackGame: callbackGame)
	}

	void payButton(String text) {
		buttons << new InlineKeyboardButton(text: text, pay: true)
	}

	List<InlineKeyboardButton> getButtons() {
		this.buttons
	}
}