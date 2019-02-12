package tech.teslex.telegroo.impl.update

import tech.teslex.telegroo.api.update.Update

class TelegrooUpdate implements Update {

	Map updateData

	TelegrooUpdate(Map updateData) {
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
