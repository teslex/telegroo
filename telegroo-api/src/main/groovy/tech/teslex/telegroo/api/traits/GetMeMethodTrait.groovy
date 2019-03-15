package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.types.User

@CompileStatic
trait GetMeMethodTrait implements Context {

	TelegramResult<User> getMe() {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, User)

		jacksonObjectMapper.readValue(api.go('getMe', [:]).returnContent().asStream(), type)
	}
}