package tech.teslex.telegroo.simple

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import org.apache.http.HttpEntity
import org.apache.http.client.fluent.Request
import org.apache.http.client.fluent.Response
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia

@CompileStatic
class SimpleApi implements Api {

	private String token

	String proto = 'https'
	String url = 'api.telegram.org'

	Map defaultParams = [:]

	ObjectMapper objectMapper

	SimpleApi(String token) {
		this.token = token

		this.objectMapper = new ObjectMapper()
	}

	SimpleApi(String token, ObjectMapper objectMapper) {
		this.token = token
		this.objectMapper = objectMapper
	}

	String buildUrl(method) {
		"$proto://$url/bot$token/$method"
	}

	@Override
	Response go(MethodObject methodObject) {
		Request.Post(buildUrl(methodObject.pathMethod))
				.addHeader('Content-Type', 'application/json')
				.bodyString(objectMapper.writeValueAsString(methodObject), ContentType.APPLICATION_JSON)
				.execute()
	}

	@Override
	Response go(MethodObjectWithFile methodObjectWithFile) {
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
					.execute()
		} else {
			if (methodObjectWithFile.file.isId)
				params += [photo: [file_id: methodObjectWithFile.file.file]]
			else
				params += [photo: methodObjectWithFile.file.file]

			go(methodObjectWithFile.pathMethod, params)
		}
	}

	@Override
	Response go(MethodObjectWithMedia methodObjectWithMedia) {
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
				.execute()
	}

	@Override
	Response go(String method, Map parameters) {
		Request.Post(buildUrl(method))
				.addHeader('Content-Type', 'application/json')
				.bodyString(objectMapper.writeValueAsString(parameters), ContentType.APPLICATION_JSON)
				.execute()
	}
}
