package tech.teslex.telegroo.api

import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import groovy.transform.CompileStatic

@CompileStatic
class WebServer {

	static HttpServer start(String path = '/', int port, HttpHandler handler) {
		def server = HttpServer.create(new InetSocketAddress(port), 0)

		server.createContext(path, handler)
		server.start()

		server
	}
}
