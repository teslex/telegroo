package tech.teslex.telegroo.api

import groovy.json.JsonSlurper
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovyx.net.http.HttpBuilder
import org.apache.http.HttpEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

@CompileStatic
class Api {

	String proto

	String url

	String token

	def http

	Api(String proto = 'https', String url = 'api.telegram.org', String token) {
		this.proto = proto
		this.url = url
		this.token = token

		http = HttpBuilder.configure {
			request.uri = "$proto://$url"
		}
	}

	@CompileDynamic
	def go(String method, Map params = [:]) {
		def response = http.post {
			request.uri.path = "/bot$token/$method"
			if (!params.isEmpty())
				request.body = params

			request.contentType = 'application/json'
		}

		if (!response.ok)
			throw new Exception("$response.error_code : $response.description")

		return response
	}

	@CompileDynamic
	def goWithFile(String method, File file, String type = 'document', Map params = [:]) {
		CloseableHttpClient httpClient = HttpClients.createDefault()
		HttpPost uploadFile = new HttpPost("$proto://$url/bot$token/$method?" + params.collect {
			"$it.key=$it.value"
		}.join("&"))

		MultipartEntityBuilder builder = MultipartEntityBuilder.create()

		params.eachWithIndex { v, i ->
			builder.addTextBody("$i", "$v")
		}

		builder.addBinaryBody(type, new FileInputStream(file), ContentType.MULTIPART_FORM_DATA, file.name)

		HttpEntity multipart = builder.build()
		uploadFile.entity = multipart
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(uploadFile)
		HttpEntity responseEntity = closeableHttpResponse.entity

		def response = new JsonSlurper().parse(responseEntity.content.text.bytes)

		if (!response.ok)
			throw new Exception("$response.error_code : $response.description")

		return response
	}
}
