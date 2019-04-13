package tech.teslex.telegroo.dsl.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;

public interface CommandsDSL {

	void start(@DelegatesTo(MethodsContext.class) Closure handler);

	void stop(@DelegatesTo(MethodsContext.class) Closure handler);

	void create(@DelegatesTo(MethodsContext.class) Closure handler);

	void delete(@DelegatesTo(MethodsContext.class) Closure handler);

	void edit(@DelegatesTo(MethodsContext.class) Closure handler);

	void join(@DelegatesTo(MethodsContext.class) Closure handler);

	void leave(@DelegatesTo(MethodsContext.class) Closure handler);

	void open(@DelegatesTo(MethodsContext.class) Closure handler);

	void close(@DelegatesTo(MethodsContext.class) Closure handler);

	void echo(@DelegatesTo(MethodsContext.class) Closure handler);
}
