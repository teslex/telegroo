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

package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import groovy.transform.SelfType
import tech.teslex.telegroo.simple.SimpleTelegramClient
import tech.teslex.telegroo.simple.context.SimpleContext
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.interfaces.GetUpdatesMethod
import tech.teslex.telegroo.telegram.methods.objects.GetUpdatesMethodObject
import tech.teslex.telegroo.telegram.types.update.Update

@CompileStatic
@SelfType(SimpleContext)
trait GetUpdatesMethodTrait implements GetUpdatesMethod<TelegramResult<List<Update>>> {

	@Override
	TelegramResult<List<Update>> getUpdates() {
		getUpdates(GetUpdatesMethodObject.newInstance())
	}

	@Override
	@NamedVariant
	TelegramResult<List<Update>> getUpdates(@NamedDelegate GetUpdatesMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, objectMapper.typeFactory.constructCollectionLikeType(ArrayList, Update))

		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}

	@Override
	TelegramResult<List<Update>> getUpdates(Map data) {
		getUpdates(data as GetUpdatesMethodObject)
	}

	@Override
	TelegramResult<List<Update>> getUpdates(@DelegatesTo(GetUpdatesMethodObject) Closure closure) {
		GetUpdatesMethodObject builder = new GetUpdatesMethodObject()
		closure.delegate = builder
		closure.call()
		getUpdates(builder)
	}
}
