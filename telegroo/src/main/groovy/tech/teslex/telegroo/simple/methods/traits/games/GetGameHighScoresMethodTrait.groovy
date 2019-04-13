package tech.teslex.telegroo.simple.methods.traits.games

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.games.GetGameHighScoresMethod
import tech.teslex.telegroo.telegram.methods.objects.games.GetGameHighScoresMethodObject
import tech.teslex.telegroo.telegram.types.games.GameHighScore

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetGameHighScoresMethodTrait implements GetGameHighScoresMethod<TelegramResult<List<GameHighScore>>> {

	@Override
	TelegramResult<List<GameHighScore>> getGameHighScores(Map data) {
		getGameHighScores(data as GetGameHighScoresMethodObject)
	}

	@Override
	@NamedVariant
	TelegramResult<List<GameHighScore>> getGameHighScores(@NamedDelegate GetGameHighScoresMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, objectMapper.typeFactory.constructCollectionLikeType(ArrayList, GameHighScore))

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<List<GameHighScore>> getGameHighScores(@DelegatesTo(GetGameHighScoresMethodObject) Closure closure) {
		GetGameHighScoresMethodObject builder = new GetGameHighScoresMethodObject()
		closure.delegate = builder
		closure.call()
		getGameHighScores(builder)
	}
}
