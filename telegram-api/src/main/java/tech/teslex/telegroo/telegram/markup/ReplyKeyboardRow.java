package tech.teslex.telegroo.telegram.markup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import tech.teslex.telegroo.telegram.api.types.KeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReplyKeyboardRow {
	public void button(@DelegatesTo(value = KeyboardButton.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		KeyboardButton button = new KeyboardButton();
		closure.setDelegate(button);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		DefaultGroovyMethods.leftShift(buttons, button);
	}

	public void button(KeyboardButton button) {
		DefaultGroovyMethods.leftShift(buttons, button);
	}

	public List<KeyboardButton> getButtons() {
		return this.buttons;
	}

	public void button(Map __namedArgs) {
	}

	private final List<KeyboardButton> buttons = new ArrayList<KeyboardButton>();
}
