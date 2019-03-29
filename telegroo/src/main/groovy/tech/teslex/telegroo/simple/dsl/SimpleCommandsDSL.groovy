package tech.teslex.telegroo.simple.dsl


import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.api.dsl.CommandsDSL
import tech.teslex.telegroo.simple.SimpleTelegroo

@CompileStatic
class SimpleCommandsDSL implements CommandsDSL {

	private SimpleTelegroo telegroo

	SimpleCommandsDSL(SimpleTelegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void start(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('start', handler)
	}

	@Override
	void stop(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('stop', handler)
	}

	@Override
	void create(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('create', handler)
	}

	@Override
	void delete(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('delete', handler)
	}

	@Override
	void edit(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('edit', handler)
	}

	@Override
	void join(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('join', handler)
	}

	@Override
	void leave(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('leave', handler)
	}

	@Override
	void open(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('open', handler)
	}

	@Override
	void close(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('close', handler)
	}

	@Override
	void echo(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('echo', handler)
	}

	@Override
	def invokeMethod(String name, Object args) {
		telegroo.command(name, args as Closure)
	}
}
