package tech.teslex.telegroo.api

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.transform.CompileStatic
import org.apache.http.HttpEntity
import org.apache.http.client.fluent.Request
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import tech.teslex.telegroo.api.req.Some
import tech.teslex.telegroo.api.req.SomeFile
import tech.teslex.telegroo.api.req.SomeMediaGroup

@CompileStatic
class Api {

	String proto

	String url

	String token

	JsonSlurper slurper

	Map defaultParams = [:]

	Api(String proto = 'https', String url = 'api.telegram.org', String token) {
		this.proto = proto
		this.url = url
		this.token = token

		slurper = new JsonSlurper()
	}

	def go(Some some) {
		go(some.method, some.params)
	}

	def go(SomeFile some) {
		goWithFile(some.method, some.file, some.type, some.params)
	}

	def go(SomeMediaGroup some) {
		def m = []
		some.media.each {
			m.add([type: it.type, media: it.file])
		}

		goWithMediaGroup(some.method, m, some.params)
	}

	def go(String method, Map params = [:]) {
		params += defaultParams

		def response = slurper.parse(Request.Post(buildUrl(method))
				.addHeader('Content-Type', 'application/json')
				.bodyString(JsonOutput.toJson(params), ContentType.APPLICATION_JSON)
				.execute().returnContent().asStream())

		if (!response['ok'])
			throw new Exception("${response['error_code']} : ${response['description']}")

		return response
	}

	def goWithFile(String method, File file, String type = 'document', Map params = [:]) {
		params += defaultParams

		HttpEntity entity = MultipartEntityBuilder
				.create().with {

			params.each {
				addTextBody(it.key as String, (it.value instanceof Map || it.value instanceof List ? JsonOutput.toJson(it.value) : it.value) as String)
			}

			addBinaryBody(type, file, ContentType.MULTIPART_FORM_DATA, type)
			build()
		}

		def response = slurper.parse(Request.Post(buildUrl(method))
				.body(entity)
				.execute().returnContent().asStream())

		if (!response['ok'])
			throw new Exception("${response['error_code']} : ${response['description']}")

		return response
	}

	def goWithMediaGroup(String method, List<Map<String, Object>> media, Map params = [:]) {
		params += defaultParams

		def nmedia = []
		media.each { entry ->
			nmedia += ([type: entry.type, media: entry['media'] instanceof File ? "attach://${entry['media']['name']}" : entry['media']])
		}
		params['media'] = nmedia

		HttpEntity entity = MultipartEntityBuilder
				.create().with {
			params.each {
				addTextBody(it.key as String, (it.value instanceof Map || it.value instanceof List ? JsonOutput.toJson(it.value) : it.value) as String)
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
			throw new Exception("${response['error_code']} : ${response['description']}")

		return response
	}

	String buildUrl(String method = '') {
		"$proto://$url/bot$token/$method"
	}
}