package tech.teslex.telegroo.api.methods.reply;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.telegram.TelegramResult;
import tech.teslex.telegroo.telegram.methods.MethodObject;

public interface WithMethodObject {

	<T extends MethodObject> TelegramResult<Object> withMethodObject(Class<T> type, @DelegatesTo(type = "T") Closure closure);
}
