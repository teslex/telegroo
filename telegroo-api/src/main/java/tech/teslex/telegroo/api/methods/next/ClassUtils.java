package tech.teslex.telegroo.api.methods.next;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

import java.lang.reflect.InvocationTargetException;

public class ClassUtils {

	public static <T extends MethodObject> T delegate(Class<T> t, @DelegatesTo(type = "T", strategy = Closure.DELEGATE_FIRST) Closure closure) {
		try {
			return delegate(t.getDeclaredConstructor().newInstance(), closure);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T extends MethodObject> T delegate(T object, @DelegatesTo(type = "T", strategy = Closure.DELEGATE_FIRST) Closure closure) {
		closure.setDelegate(object);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();

		return object;
	}
}
