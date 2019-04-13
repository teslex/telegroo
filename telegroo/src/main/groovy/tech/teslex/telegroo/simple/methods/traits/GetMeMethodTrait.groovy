package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.GetMeMethod
import tech.teslex.telegroo.telegram.types.User

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetMeMethodTrait implements GetMeMethod<TelegramResult<User>> {

	@Override
	TelegramResult<User> getMe() {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, User)

		objectMapper.readValue(telegramClient.go('getMe', [:]).returnContent().asStream(), type)
	}
}