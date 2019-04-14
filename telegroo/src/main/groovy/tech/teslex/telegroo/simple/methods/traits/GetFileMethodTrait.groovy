package tech.teslex.telegroo.simple.methods.traits

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
import tech.teslex.telegroo.telegram.methods.interfaces.GetFileMethod
import tech.teslex.telegroo.telegram.methods.objects.GetFileMethodObject
import tech.teslex.telegroo.telegram.types.FileObject

@CompileStatic
@SelfType(ContextWithObjectMapper)
trait GetFileMethodTrait implements GetFileMethod<TelegramResult<FileObject>> {

	@Override
	@NamedVariant
	TelegramResult<FileObject> getFile(@NamedDelegate GetFileMethodObject data) {
		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, FileObject)

		objectMapper.readValue(telegramClient.go(data).returnContent().asStream(), type)
	}

	@Override
	TelegramResult<FileObject> getFile(Map data) {
		getFile(data as GetFileMethodObject)
	}

	@Override
	TelegramResult<FileObject> getFile(@DelegatesTo(GetFileMethodObject) Closure closure) {
		GetFileMethodObject builder = new GetFileMethodObject()
		closure.delegate = builder
		closure.call()
		getFile(builder)
	}
}
