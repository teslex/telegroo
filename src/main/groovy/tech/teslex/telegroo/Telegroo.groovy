package tech.teslex.telegroo

import com.sun.net.httpserver.HttpServer
import groovy.json.JsonSlurper
import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Actions
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.WebServer

@CompileStatic
class Telegroo implements Bot, Actions {

	String token

	Api api

	Map lastUpdate = [update_id: 0],
		handles = [
				message: [:] as Map<String, Closure>,
				update : [] as List<Closure>
		]

	List<Closure<Boolean>> middles = []

	Closure catchException = { Exception e ->
		e.printStackTrace()
		stop()
	}

	Map me = null

	boolean active = false

	boolean isWebhook = false

	HttpServer webhookServer

	Telegroo(String token) {
		this.token = token
		this.api = new Api(token)
	}

	void start() {
		if (active)
			return

		active = true

		while (active) {
			try {
				def updates = getUpdates((lastUpdate['update_id'] as Integer) + 1)['result'] as List

				for (update in updates)
					solve(update as Map)
			} catch (ex) {
				catchException ex
			}
		}
	}

	Thread startAsync() {
		Thread.start {
			start()
		}
	}

	HttpServer startWebhook(int port = 0) {
		startWebhook('/', port)
	}

	HttpServer startWebhook(String path, int port = 0) {
		active = true
		isWebhook = true

		webhookServer = WebServer.start(path, port, { exchange ->
			try {
				def update = new JsonSlurper().parse(exchange.requestBody) as Map
				solve(update)

				exchange.sendResponseHeaders(200, 0)
				exchange.responseBody.withWriter('UTF-8') { it.write('OK') }
			} catch (e) {
				exchange.sendResponseHeaders(500, 0)
				exchange.responseBody.withWriter('UTF-8') { it.write('FAIL') }

				catchException e
			}
		})
	}

	void stop() {
		if (!active)
			return

		if (isWebhook) {
			webhookServer.stop(0)
			deleteWebhook()
		}

		active = false
	}

	boolean checkMid(Map update) {
		for (mid in middles)
			if (!mid(update))
				return false

		return true
	}

	void solveUpdate(Map update) {
		handles.update.each { Closure closure ->
			closure(update)
		}

		if (update.keySet()[1] == 'message') {
			def handle = (handles.message as Map).find {
				update['message']['text'] ==~ it.key
			} as Map.Entry<String, Closure>

			if (handle)
				if (handle.value.maximumNumberOfParameters == 1)
					(handle.value as Closure)([update: update, match: update['message']['text'] =~ handle.key])
				else
					(handle.value as Closure)(update, update['message']['text'] =~ handle.key)
		} else {
			def handle = (handles[update.keySet()[1] as String])

			if (handle)
				(handle as Closure)(update)
		}
	}

	void solve(Map update) {
		lastUpdate = update
		if (checkMid(lastUpdate))
			solveUpdate(lastUpdate)
	}

	void onUpdate(Closure closure) {
		(handles.update as List).add(closure)
	}

	void onCommand(String command, Closure closure) {
		(handles.message as Map).put(command.startsWith('/') ? command : "/$command", closure)
	}

	void onMessage(String message, Closure closure) {
		(handles.message as Map).put(message, closure)
	}

	void on(String type, Closure closure) {
		handles[type] = closure
	}

	void middleware(Closure<Boolean> closure) {
		middles.add(closure)
	}
}