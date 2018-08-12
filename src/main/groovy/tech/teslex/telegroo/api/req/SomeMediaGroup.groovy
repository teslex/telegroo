package tech.teslex.telegroo.api.req

import groovy.transform.CompileStatic

@CompileStatic
class SomeMediaGroup extends Some {

	List<SomeFile> media

	SomeMediaGroup(List<? extends SomeFile> media, Map params = [:]) {
		super('sendMediaGroup', params)
		this.media = media as List<SomeFile>
	}
}
