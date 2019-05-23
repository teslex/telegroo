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

package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.fluent.Request
import org.apache.http.client.fluent.Response
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.simple.jackson.JacksonObjectMapper
import tech.teslex.telegroo.telegram.api.TelegramErrorException
import tech.teslex.telegroo.telegram.api.TelegramResult
import tech.teslex.telegroo.telegram.api.methods.MethodObject
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithMedia
import tech.teslex.telegroo.telegram.api.types.input.InputMedia
import tech.teslex.telegroo.telegram.attach.FileInputFile
import tech.teslex.telegroo.telegram.attach.IdInputFile

/**
 * Simple TelegramClient implementation
 */
@CompileStatic
class SimpleTelegramClient implements TelegramClient<Response> {

	String token

	String proto = 'https'
	String url = 'api.telegram.org'

	Map defaultParams = [:]

	ObjectMapper objectMapper = JacksonObjectMapper.objectMapper

	SimpleTelegramClient(String token, Map defaultParams = [:]) {
		this.token = token
		this.defaultParams = defaultParams
	}

	String buildUrl(method) {
		"$proto://$url/bot$token/$method"
	}

	@Override
	Response go(MethodObject methodObject) {
		makeRequest(methodObject).execute()
	}

	@Override
	Response go(MethodObjectWithFile methodObjectWithFile) {
		makeRequest(methodObjectWithFile).execute()
	}

	@Override
	Response go(MethodObjectWithMedia methodObjectWithMedia) {
		makeRequest(methodObjectWithMedia).execute()
	}

	@Override
	Response go(String method, Map parameters) {
		makeRequest(method, parameters).execute()
	}

	Request makeRequest(MethodObject methodObject) {
		Map params = objectMapper.convertValue(methodObject, Map)
		params += defaultParams

		Request.Post(buildUrl(methodObject.pathMethod))
				.useExpectContinue()
				.addHeader('Content-Type', 'application/json')
				.bodyString(objectMapper.writeValueAsString(params), ContentType.APPLICATION_JSON)
	}

	Request makeRequest(MethodObjectWithFile methodObjectWithFile) {
		Map params = objectMapper.convertValue(methodObjectWithFile, Map)
		params += defaultParams

		if (methodObjectWithFile.file instanceof FileInputFile) {
			HttpEntity entity = MultipartEntityBuilder.create().tap {

				// adding params to body
				params.each { Map.Entry param ->
					addTextBody(param.key as String, objectMapper.writeValueAsString(param.value))
				}

				// adding file to body
				addBinaryBody(methodObjectWithFile.file.mediaType.value, methodObjectWithFile.file.file as File, ContentType.MULTIPART_FORM_DATA, methodObjectWithFile.file.mediaType.value)
			}.build()

			Request.Post(buildUrl(methodObjectWithFile.pathMethod))
					.body(entity)
		} else {
			if (methodObjectWithFile.file instanceof IdInputFile)
				params += [photo: [file_id: methodObjectWithFile.file.file]]
			else
				params += [photo: methodObjectWithFile.file.file]

			makeRequest(methodObjectWithFile.pathMethod, params)
		}
	}

	Request makeRequest(MethodObjectWithMedia methodObjectWithMedia) {
		Map params = objectMapper.convertValue(methodObjectWithMedia, Map)
		params += defaultParams

		// collecting media to normal map
		params['media'] = methodObjectWithMedia.media.collect { inputMedia ->
			objectMapper.convertValue(inputMedia, Map).tap {
				if (inputMedia.media instanceof FileInputFile)
					media = "attach://${(inputMedia.media.file as File).name}" as String
				else if (inputMedia.media instanceof IdInputFile)
					media = [file_id: inputMedia.media.file]
				else
					media = inputMedia.media.file
			}
		}

		HttpEntity entity = MultipartEntityBuilder.create().tap {

			// adding params to body
			params.each { Map.Entry param ->
				addTextBody(param.key as String, objectMapper.writeValueAsString(param.value))
			}

			// adding media files to body
			methodObjectWithMedia.media.findAll { it.media instanceof FileInputFile }.each { InputMedia inputMedia ->
				addBinaryBody((inputMedia.media.file as File).name, inputMedia.media.file as File, ContentType.MULTIPART_FORM_DATA, (inputMedia.media.file as File).name)
			}
		}.build()

		Request.Post(buildUrl(methodObjectWithMedia.pathMethod))
				.body(entity)
	}

	Request makeRequest(String method, Map parameters) {
		Request.Post(buildUrl(method))
				.addHeader('Content-Type', 'application/json')
				.bodyString(objectMapper.writeValueAsString(parameters), ContentType.APPLICATION_JSON)
	}

	static <T> TelegramResult<T> handleResponse(HttpResponse response, JavaType type) {
		TelegramResult result = JacksonObjectMapper.objectMapper.readValue(response.entity.content.text, type)

		if (result.ok)
			return result
		else
			throw new TelegramErrorException(result)
	}
}
