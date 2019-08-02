//package tech.teslex.telegroo.telegram.markup;
//
//import groovy.lang.Closure;
//import groovy.lang.DelegatesTo;
//import org.codehaus.groovy.runtime.DefaultGroovyMethods;
//import tech.teslex.telegroo.telegram.api.types.KeyboardButton;
//import tech.teslex.telegroo.telegram.api.types.ReplyKeyboardMarkup;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ReplyKeyboardMarkupMaker {
//	public void row(@DelegatesTo(value = ReplyKeyboardRow.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		ReplyKeyboardRow row = new ReplyKeyboardRow();
//		closure.setDelegate(row);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		markup.getKeyboard().add(row.getButtons());
//	}
//
////	public ReplyKeyboardMarkup getMarkup() {
////		return this.markup;
////	}
////
////	{
////		LinkedHashMap<String, List<Object>> map = new LinkedHashMap<String, List<Object>>(1);
////		map.put("keyboard", new ArrayList());
////		markup = new ReplyKeyboardMarkup(map);
////	}
////
////	private final ReplyKeyboardMarkup markup;
//}
//
