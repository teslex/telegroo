package tech.teslex.telegroo.dsl

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.dsl.api.TelegrooDSL
import tech.teslex.telegroo.dsl.simple.SimpleTelegrooDSL

@CompileStatic
class TDSL {

	static forBot(Telegroo telegroo, @DelegatesTo(TelegrooDSL) Closure closure) {
		SimpleTelegrooDSL tdsl = new SimpleTelegrooDSL(telegroo)
		closure.delegate = tdsl
		closure()
	}

	protected static fromText(Telegroo telegroo, String text) {
		// todo: implement it
	}
}
