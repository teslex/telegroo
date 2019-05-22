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
import tech.teslex.telegroo.telegram.methods.interfaces.GetUserProfilePhotosMethod
import tech.teslex.telegroo.telegram.methods.objects.GetUserProfilePhotosMethodObject
import tech.teslex.telegroo.telegram.types.UserProfilePhotos

@CompileStatic
@SelfType(SimpleContext)
trait GetUserProfilePhotosMethodTrait implements GetUserProfilePhotosMethod<TelegramResult<UserProfilePhotos>> {

	@NamedVariant
	TelegramResult<UserProfilePhotos> getUserProfilePhotos(@NamedDelegate GetUserProfilePhotosMethodObject data) {
		data.userId = data.userId ?: update[update.updateType.value]['from']['id'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, UserProfilePhotos)

		telegramClient.go(data).handleResponse { SimpleTelegramClient.handleResponse(it, type) }
	}

	TelegramResult<UserProfilePhotos> getUserProfilePhotos(Map data) {
		getUserProfilePhotos(data as GetUserProfilePhotosMethodObject)
	}

	TelegramResult<UserProfilePhotos> getUserProfilePhotos(@DelegatesTo(value = GetUserProfilePhotosMethodObject, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		GetUserProfilePhotosMethodObject builder = new GetUserProfilePhotosMethodObject()
		closure.delegate = builder
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure.call()
		getUserProfilePhotos(builder)
	}
}
