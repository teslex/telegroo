package tech.teslex.telegroo.simple

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.transform.CompileStatic
import org.apache.http.HttpEntity
import org.apache.http.client.fluent.Request
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomeFile
import tech.teslex.telegroo.api.some.SomeMediaGroup

// Rewrite me please
@CompileStatic
class SimpleApi implements Api {

	String token

	String proto = 'https'
	String url = 'api.telegram.org'

	Map defaultParams = [:]

	JsonSlurper slurper

	SimpleApi(String token) {
		this.token = token
		this.slurper = new JsonSlurper()
	}


	@Override
	def go(Some some) {
		go(some.method, some.params)
	}

	@Override
	def go(SomeFile someFile) {
		goWithFile(someFile.method, someFile.file, someFile.type, someFile.params)
	}

	@Override
	def go(SomeMediaGroup someMediaGroup) {
		goWithMediaGroup(someMediaGroup.method, someMediaGroup.media, someMediaGroup.params)
	}

	@Override
	def go(method, params = [:]) {
		params = params as Map // fuck ;(
		params += defaultParams

		def response = slurper.parse(Request.Post(buildUrl(method))
				.addHeader('Content-Type', 'application/json')
				.bodyString(JsonOutput.toJson(params), ContentType.APPLICATION_JSON)
				.execute().returnContent().asStream())

		if (!response['ok'])
			throw new RuntimeException("${response['error_code']} : ${response['description']}")

		return response
	}

	@Override
	def goWithFile(method, file, type, params = [:]) {
		params = params as Map
		params += defaultParams

		HttpEntity entity = MultipartEntityBuilder.create().with {

			// adding params to body
			params.each { Map.Entry param ->
				def value = JsonOutput.toJson(param.value)
				addTextBody(param.key as String, value)
			}

			// adding file to body
			addBinaryBody(type as String, file as File, ContentType.MULTIPART_FORM_DATA, type as String)

			build()
		}

		def response = slurper.parse(Request.Post(buildUrl(method))
				.body(entity)
				.execute().returnContent().asStream())

		if (!response['ok'])
			throw new RuntimeException("${response['error_code']} : ${response['description']}")

		return response
	}


	@Override
	def goWithMediaGroup(method, media, params = [:]) {
		params = params as Map
		params += defaultParams

		def nmedia = []
		media.each { Map item ->
			nmedia += ([type: item.type, media: item['media'] instanceof File ? "attach://${item['media']['name']}" : item['media']])
		}
		params['media'] = nmedia

		HttpEntity entity = MultipartEntityBuilder.create().with {

			params.each { Map.Entry param ->
				def value = JsonOutput.toJson(param.value)
				addTextBody(param.key as String, value)
			}

			media.each { entry ->
				if (entry['media'] instanceof File)
					addBinaryBody(entry['media']['name'] as String, entry['media'] as File, ContentType.MULTIPART_FORM_DATA, entry['media']['name'] as String)
			}

			build()
		}

		def response = slurper.parse(Request.Post(buildUrl(method))
				.body(entity)
				.execute().returnContent().asStream())

		if (!response['ok'])
			throw new RuntimeException("${response['error_code']} : ${response['description']}")

		return response
	}

	String buildUrl(method) {
		"$proto://$url/bot$token/$method"
	}
}
