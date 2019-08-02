//package tech.teslex.telegroo.telegram.markup;
//
//import groovy.lang.Closure;
//import groovy.lang.DelegatesTo;
//import org.codehaus.groovy.runtime.DefaultGroovyMethods;
//import tech.teslex.telegroo.telegram.api.types.InlineKeyboardButton;
//import tech.teslex.telegroo.telegram.api.types.games.CallbackGame;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class InlineKeyboardRow {
//	private final List<InlineKeyboardButton> buttons = new ArrayList<InlineKeyboardButton>();
//
//	public void button(@DelegatesTo(value = InlineKeyboardButton.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		InlineKeyboardButton button = new InlineKeyboardButton();
//		closure.setDelegate(button);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		DefaultGroovyMethods.leftShift(buttons, button);
//	}
//
//	public void button(InlineKeyboardButton button) {
//		DefaultGroovyMethods.leftShift(buttons, button);
//	}
//
//	public void callbackButton(String text, String callbackData) {
//		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(2);
//		map.put("text", text);
//		map.put("callbackData", callbackData);
//		buttons.add(new InlineKeyboardButton(map));
//	}
//
//	public void urlButton(String text, String url) {
//		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(2);
//		map.put("text", text);
//		map.put("url", url);
//		buttons.add(new InlineKeyboardButton(map));
//	}
//
//	public void switchInlineQueryButton(String text, String switchInlineQuery) {
//		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(2);
//		map.put("text", text);
//		map.put("switchInlineQuery", switchInlineQuery);
//		buttons.add(new InlineKeyboardButton(map));
//	}
//
//	public void switchInlineQueryCurrentChatButton(String text, String switchInlineQueryCurrentChat) {
//		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(2);
//		map.put("text", text);
//		map.put("switchInlineQueryCurrentChat", switchInlineQueryCurrentChat);
//		buttons.add(new InlineKeyboardButton(map));
//	}
//
//	public void callbackGameButton(String text, CallbackGame callbackGame) {
//		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(2);
//		map.put("text", text);
//		map.put("callbackGame", callbackGame);
//		buttons.add(new InlineKeyboardButton(map));
//	}
//
//	public void callbackGameButton(String text) {
//		callbackGameButton(text, new CallbackGame());
//	}
//
//	public void payButton(String text) {
//		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(2);
//		map.put("text", text);
//		map.put("pay", true);
//		buttons.add(new InlineKeyboardButton(map));
//	}
//
//	public List<InlineKeyboardButton> getButtons() {
//		return this.buttons;
//	}
//
//	public void button(Map __namedArgs) {
//	}
//}
