package tech.teslex.telegroo

import groovy.transform.CompileStatic

@CompileStatic
interface Bot {
	void start()
	void stop()

	void onUpdate(Closure closure)
}