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

package tech.teslex.telegroo.simple.methods.traits.games

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.api.TelegramResult
import tech.teslex.telegroo.telegram.api.methods.interfaces.games.SetGameScoreMethod
import tech.teslex.telegroo.telegram.api.methods.objects.games.SetGameScoreMethodObject
import tech.teslex.telegroo.telegram.api.types.Message

@CompileStatic
@SelfType(SimpleContext)
trait SetGameScoreMethodTrait implements SetGameScoreMethod<TelegramResult<Object>> {

	@Override
	TelegramResult<Object> setGameScore(Map data) {
		setGameScore(data as SetGameScoreMethodObject)
	}

	@Override
	@NamedVariant
	TelegramResult<Object> setGameScore(@NamedDelegate SetGameScoreMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, Message)

		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}

	@Override
	TelegramResult<Object> setGameScore(@DelegatesTo(value = SetGameScoreMethodObject, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		SetGameScoreMethodObject builder = new SetGameScoreMethodObject()
		closure.delegate = builder
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure.call()
		setGameScore(builder)
	}
}