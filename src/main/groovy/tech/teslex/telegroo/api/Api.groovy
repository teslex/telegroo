package tech.teslex.telegroo.api

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovyx.net.http.HttpBuilder
import tech.teslex.telegroo.Telegroo

@CompileStatic
class Api {

	String proto

	String url

	String token

	def http

	Api(String proto = 'https', String url = 'api.telegram.org/bot', String token) {
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
}
