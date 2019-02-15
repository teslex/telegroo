package tech.teslex.telegroo.impl

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Actions
import tech.teslex.telegroo.api.Api
import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.update.Update

@CompileStatic
class SimpleContext implements Context, Actions {

	private final Api api

	private final Update lastUpdate

	SimpleContext(Api api, Update lastUpdate) {
		this.api = api
		this.lastUpdate = lastUpdate
	}

	@Override
	Api getApi() {
		return api
	}

	@Override
	Update getLastUpdate() {
		return lastUpdate
	}
}
