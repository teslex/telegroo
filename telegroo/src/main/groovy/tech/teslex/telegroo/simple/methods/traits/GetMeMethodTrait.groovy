package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.methods.interfaces.GetMeMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.types.User

@CompileStatic
trait GetMeMethodTrait implements GetMeMethod<TelegramResult<User>>, ContextWithObjectMapper {

	@Override
	TelegramResult<User> getMe() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, User)

		objectMapper.readValue(api.go('getMe', [:]).returnContent().asStream(), type)
	}
}