//package tech.teslex.telegroo.telegram.markup;
//
//import groovy.lang.Closure;
//import groovy.lang.DelegatesTo;
//import tech.teslex.telegroo.telegram.api.types.ForceReply;
//import tech.teslex.telegroo.telegram.api.types.InlineKeyboardMarkup;
//import tech.teslex.telegroo.telegram.api.types.ReplyKeyboardMarkup;
//import tech.teslex.telegroo.telegram.api.types.ReplyKeyboardRemove;
//
//public class Markup {
//	private static final ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
//	private static final ForceReply forceReply = new ForceReply();
//
//	public static InlineKeyboardMarkup inlineKeyboard(@DelegatesTo(value = InlineKeyboardMarkupMaker.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		InlineKeyboardMarkupMaker maker = new InlineKeyboardMarkupMaker();
//		closure.setDelegate(maker);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		return maker.getMarkup();
//	}
//
//	public static ReplyKeyboardMarkup replyKeyboard(@DelegatesTo(value = ReplyKeyboardMarkupMaker.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		ReplyKeyboardMarkupMaker maker = new ReplyKeyboardMarkupMaker();
//		closure.setDelegate(maker);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		return maker.getMarkup();
//	}
//
//	public static ReplyKeyboardRemove replyKeyboardRemove(@DelegatesTo(value = ReplyKeyboardRemove.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
//		closure.setDelegate(replyKeyboardRemove);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		return replyKeyboardRemove;
//	}
//
//	public static ForceReply forceReply(@DelegatesTo(value = ForceReply.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		ForceReply forceReply = new ForceReply();
//		closure.setDelegate(forceReply);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		return forceReply;
//	}
//
//	public static ReplyKeyboardRemove getReplyKeyboardRemove() {
//		return replyKeyboardRemove;
//	}
//
//	public static ForceReply getForceReply() {
//		return forceReply;
//	}
//}
