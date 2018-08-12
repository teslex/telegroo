package tech.teslex.telegroo

import groovy.transform.CompileStatic

@CompileStatic
interface Bot {
	void start()

	void stop()

	void onUpdate(Closure closure)

	void onMessage(String message, Closure closure)

	void onCommand(String command, Closure closure)
}