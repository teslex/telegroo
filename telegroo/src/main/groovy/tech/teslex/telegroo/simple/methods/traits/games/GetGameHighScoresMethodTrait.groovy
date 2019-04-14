package tech.teslex.telegroo.simple.methods.traits.games

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * © 2019 TesLex
 */

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
