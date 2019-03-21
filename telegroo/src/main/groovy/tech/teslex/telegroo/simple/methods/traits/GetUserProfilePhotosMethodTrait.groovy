package tech.teslex.telegroo.simple.methods.traits

import groovy.transform.CompileStatic
import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.methods.interfaces.GetUserProfilePhotosMethod
import tech.teslex.telegroo.simple.context.ContextWithObjectMapper
import tech.teslex.telegroo.telegram.TelegramResult
import tech.teslex.telegroo.telegram.methods.objects.GetUserProfilePhotosMethodObject
import tech.teslex.telegroo.telegram.types.UserProfilePhotos

@CompileStatic
trait GetUserProfilePhotosMethodTrait implements GetUserProfilePhotosMethod<TelegramResult<UserProfilePhotos>>, ContextWithObjectMapper {

	@NamedVariant
	TelegramResult<UserProfilePhotos> getUserProfilePhotos(@NamedDelegate GetUserProfilePhotosMethodObject data) {
		data.userId = data.userId ?: lastUpdate[lastUpdate.updateType.value]['from']['id'] as Integer

		def type = objectMapper.typeFactory.constructParametricType(TelegramResult, UserProfilePhotos)

		objectMapper.readValue(api.go(data).returnContent().asStream(), type)
	}

	TelegramResult<UserProfilePhotos> getUserProfilePhotos(Map data) {
		getUserProfilePhotos(data as GetUserProfilePhotosMethodObject)
	}

	TelegramResult<UserProfilePhotos> getUserProfilePhotos(@DelegatesTo(GetUserProfilePhotosMethodObject) Closure closure) {
		def builder = GetUserProfilePhotosMethodObject.newInstance()
		closure.delegate = builder
		closure.call()
		getUserProfilePhotos(builder)
	}
}
