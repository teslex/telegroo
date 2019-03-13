package tech.teslex.telegroo.telegram.methodsold

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.context.AbstractContext
import tech.teslex.telegroo.api.telegram.some.Some
import tech.teslex.telegroo.api.telegram.types.UserProfilePhotos

@CompileStatic
trait GetUserProfilePhotos extends AbstractContext {

	UserProfilePhotos getUserProfilePhotos(userId = lastUpdate.updateData[lastUpdate.updateType.type]['from']['id'], Map params = [:]) {
		def result = api.go(new Some('getUserProfilePhotos', [user_id: userId] + params))['result'] as Map
		return m2c2m(result, UserProfilePhotos) as UserProfilePhotos
	}
}