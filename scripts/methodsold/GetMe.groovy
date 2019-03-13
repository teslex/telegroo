package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.User

@CompileStatic
trait GetMe extends AbstractContext {

	User getMe() {
		def result = api.go(new Some('getMe'))['result'] as Map
		return m2c2m(result, User) as User
	}
}
