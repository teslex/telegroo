package tech.teslex.telegroo.api.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.api.context.Context
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.builders.GetUserProfilePhotosMethodObjectBuilder
import tech.teslex.telegroo.telegram.methods.objects.GetUserProfilePhotosMethodObject
import tech.teslex.telegroo.telegram.types.UserProfilePhotos

@CompileStatic
trait GetUserProfilePhotosMethodTrait implements Context {

	@NamedVariant
	TelegramResult<UserProfilePhotos> getUserProfilePhotos(@NamedDelegate GetUserProfilePhotosMethodObject data) {
		data.userId = data.userId ?: lastUpdate[lastUpdate.updateType.type]['from']['id'] as Integer

		def type = jacksonObjectMapper.typeFactory.constructParametricType(TelegramResult, UserProfilePhotos)

		jacksonObjectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<UserProfilePhotos> getUserProfilePhotos(Map data) {
		getUserProfilePhotos(data as GetUserProfilePhotosMethodObject)
	}

	TelegramResult<UserProfilePhotos> getUserProfilePhotos(@DelegatesTo(GetUserProfilePhotosMethodObjectBuilder) Closure closure) {
		def builder = new GetUserProfilePhotosMethodObjectBuilder()
		closure.delegate = builder
		closure.call()
		getUserProfilePhotos(builder.build())
	}
}
