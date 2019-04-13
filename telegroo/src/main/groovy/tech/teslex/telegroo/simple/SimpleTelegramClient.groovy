package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import groovy.transform.CompileStatic
import org.apache.http.HttpEntity
import org.apache.http.client.fluent.Request
import org.apache.http.client.fluent.Response
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import tech.teslex.telegroo.api.TelegramClient
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia

@CompileStatic
class SimpleTelegramClient implements TelegramClient<Response> {

	String token

	String proto = 'https'
	String url = 'api.telegram.org'

	Map defaultParams = [:]

	ObjectMapper objectMapper

	SimpleTelegramClient(String token) {
		this.token = token

		this.objectMapper = new ObjectMapper()
		this.objectMapper.registerModule(new Jdk8Module())
		this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
	}

	SimpleTelegramClient(String token, ObjectMapper objectMapper) {
		this.token = token
		this.objectMapper = objectMapper
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

		if (methodObjectWithFile.file.file instanceof File) {
			HttpEntity entity = MultipartEntityBuilder.create().tap {

				// adding params to body
				params.each { Map.Entry param ->
					def value = param.value instanceof Number ||
							param.value instanceof String ||
							param.value.class.isPrimitive() ? param.value : objectMapper.writeValueAsString(param.value)

					addTextBody(param.key as String, value as String)
				}

				// adding file to body
				addBinaryBody(methodObjectWithFile.file.mediaType, methodObjectWithFile.file.file as File, ContentType.MULTIPART_FORM_DATA, methodObjectWithFile.file.mediaType)
			}.build()

			Request.Post(buildUrl(methodObjectWithFile.pathMethod))
					.body(entity)
		} else {
			if (methodObjectWithFile.file.isId)
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
				media = (inputMedia.media.isFile ? "attach://${(inputMedia.media.file as File).name}" :
						inputMedia.media.isId ? [file_id: inputMedia.media.file] : inputMedia.media.file)
			}
		}

		HttpEntity entity = MultipartEntityBuilder.create().tap {

			// adding params to body
			params.each { Map.Entry param ->
				def value = param.value instanceof Number ||
						param.value instanceof String ||
						param.value.class.isPrimitive() ? param.value : objectMapper.writeValueAsString(param.value)

				addTextBody(param.key as String, value as String)
			}

			// adding media files to body
			methodObjectWithMedia.media.each { entry ->
				if (entry.media.isFile)
					addBinaryBody((entry.media.file as File).name, entry.media.file as File, ContentType.MULTIPART_FORM_DATA, (entry.media.file as File).name)
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
}
