package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.types.User

@CompileStatic
trait GetMeMethodTrait implements Context<Response> {

	TelegramResult<User> getMe() {
		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, User)

		jacksonObjectMapper.readValue(api.go('getMe', [:]).returnContent().asStream(), type)
	}
}