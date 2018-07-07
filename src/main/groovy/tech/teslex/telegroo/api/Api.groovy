package tech.teslex.telegroo.api

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovyx.net.http.HttpBuilder
import jdk.nashorn.internal.runtime.URIUtils
import org.apache.http.HttpEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.utils.URLEncodedUtils
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import sun.net.util.URLUtil

@CompileStatic
class Api {

	String proto

	String url

	String token

	def http

	def defaultParams = [:]

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
				request.body = (params + defaultParams)

			request.contentType = 'application/json'
		}

		if (!response.ok)
			throw new Exception("$response.error_code : $response.description")

		return response
	}

	@CompileDynamic
	def goWithFile(String method, File file, String type = 'document', Map params = [:]) {
		CloseableHttpClient httpClient = HttpClients.createDefault()
		HttpPost uploadFile = new HttpPost("$proto://$url/bot$token/$method?" + (params + defaultParams).collect {
			"$it.key=${URLEncoder.encode((it.value instanceof Map || it.value instanceof List ? JsonOutput.toJson(it.value) : it.value) as String, 'UTF-8')}"
		}.join("&"))

		MultipartEntityBuilder builder = MultipartEntityBuilder.create()

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

	def goWithMedia(String method, Map media, Map params = [:]) {

	}
}
