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

// Rewrite me please
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

//	@Override
//	def go(method, params = [:]) {
//		params = params as Map // fuck ;(
//		params += defaultParams
//
//		def response = slurper.parse(Request.Post(buildUrl(method))
//				.addHeader('Content-Type', 'application/json')
//				.bodyString(JsonOutput.toJson(params), ContentType.APPLICATION_JSON)
//				.execute().returnContent().asStream())
//
//		if (!response['ok'])
//			throw new RuntimeException("${response['error_code']} : ${response['description']}")
//
//		return response
//	}
//
//	@Override
//	def goWithFile(method, file, type, params = [:]) {
//		params = params as Map
//		params += defaultParams
//
//		HttpEntity entity = MultipartEntityBuilder.create().with {
//
//			// adding params to body
//			params.each { Map.Entry param ->
//				def value = JsonOutput.toJson(param.value)
//				addTextBody(param.key as String, value)
//			}
//
//			// adding file to body
//			addBinaryBody(type as String, file as File, ContentType.MULTIPART_FORM_DATA, type as String)
//
//			build()
//		}
//
//		def response = slurper.parse(Request.Post(buildUrl(method))
//				.body(entity)
//				.execute().returnContent().asStream())
//
//		if (!response['ok'])
//			throw new RuntimeException("${response['error_code']} : ${response['description']}")
//
//		return response
//	}
//
//
//	@Override
//	def goWithMediaGroup(method, media, params = [:]) {
//		params = params as Map
//		params += defaultParams
//
//		def nmedia = []
//		media.each { Map item ->
//			nmedia += ([type: item.type, media: item['media'] instanceof File ? "attach://${item['media']['name']}" : item['media']])
//		}
//		params['media'] = nmedia
//
//		HttpEntity entity = MultipartEntityBuilder.create().with {
//
//			params.each { Map.Entry param ->
//				def value = JsonOutput.toJson(param.value)
//				addTextBody(param.key as String, value)
//			}
//
//			media.each { entry ->
//				if (entry['media'] instanceof File)
//					addBinaryBody(entry['media']['name'] as String, entry['media'] as File, ContentType.MULTIPART_FORM_DATA, entry['media']['name'] as String)
//			}
//
//			build()
//		}
//
//		def response = slurper.parse(Request.Post(buildUrl(method))
//				.body(entity)
//				.execute().returnContent().asStream())
//
//		if (!response['ok'])
//			throw new RuntimeException("${response['error_code']} : ${response['description']}")
//
//		return response
//	}

	String buildUrl(method) {
		"$proto://$url/bot$token/$method"
	}

	@Override
	Response go(String method) {
		go(method, [:])
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
				addBinaryBody(methodObjectWithFile.fileType.type, methodObjectWithFile.file.file as File, ContentType.MULTIPART_FORM_DATA, methodObjectWithFile.fileType.type)
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
	Response go(String method, Map parameters) {
		Request.Post(buildUrl(method))
				.addHeader('Content-Type', 'application/json')
				.bodyString(objectMapper.writeValueAsString(parameters), ContentType.APPLICATION_JSON)
				.execute()
	}
}
