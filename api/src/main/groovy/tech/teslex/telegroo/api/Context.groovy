package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.update.Update

interface Context extends Methods {

	Api getApi()

	Update getLastUpdate()
}
