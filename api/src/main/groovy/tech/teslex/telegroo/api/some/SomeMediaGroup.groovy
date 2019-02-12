package tech.teslex.telegroo.api.some

import groovy.transform.CompileStatic

@CompileStatic
class SomeMediaGroup extends Some {

	List<SomeFile> media

	SomeMediaGroup(List<SomeFile> media, Map params = [:]) {
		super('sendMediaGroup', params)
		this.media = media as List<SomeFile>
	}
}
