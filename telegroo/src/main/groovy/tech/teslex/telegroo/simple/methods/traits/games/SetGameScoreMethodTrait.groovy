package tech.teslex.telegroo.simple.methods.traits.games

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.games.SetGameScoreMethod
import tech.teslex.telegroo.telegram.methods.objects.games.SetGameScoreMethodObject
import tech.teslex.telegroo.telegram.types.Message

@CompileStatic
trait SetGameScoreMethodTrait implements SetGameScoreMethod<TelegramResult<Object>>, ContextWithObjectMapper {

	@Override
	TelegramResult<Object> setGameScore(Map data) {
		setGameScore(data as SetGameScoreMethodObject)
	}

	@Override
	@NamedVariant
	TelegramResult<Object> setGameScore(@NamedDelegate SetGameScoreMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<Object> setGameScore(@DelegatesTo(SetGameScoreMethodObject) Closure closure) {
		def builder = SetGameScoreMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		setGameScore(builder)
	}
}