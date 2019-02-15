package tech.teslex.telegroo.api

import tech.teslex.telegroo.api.update.Update

interface Context extends Actions {

	Api getApi()

	Update getLastUpdate()
}
