package tech.teslex.telegroo.simple.update

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.update.Update

@CompileStatic
class SimpleUpdate implements Update {

	Map updateData

	SimpleUpdate(Map updateData) {
		this.updateData = updateData
	}

	def getUpdateType() {
		updateData.keySet()[1]
	}

	@Override
	String toString() {
		return updateData.toString()
	}
}
