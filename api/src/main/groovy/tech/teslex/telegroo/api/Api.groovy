package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.some.Some
import tech.teslex.telegroo.api.some.SomeFile
import tech.teslex.telegroo.api.some.SomeMediaGroup

interface Api {

	def go(Some some)

	def go(SomeFile someFile)

	def go(SomeMediaGroup someMediaGroup)

	def go(method, params)

	def goWithFile(method, file, type, params)

	def goWithMediaGroup(method, media, params)

	void setDefaultParams(Map params)

	Map getDefaultParams()
}
