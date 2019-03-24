package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectAnnotations

/**
 * getUserProfilePhotos
 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
 */
@MethodObjectAnnotations
class GetUserProfilePhotosMethodObject implements MethodObject {

	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(value = 'user_id', required = true)
	Integer userId

	/**
	 * Sequential number of the first photo to be returned. By default, all photos are returned.
	 */
	@JsonProperty(required = false)
	Integer offset

	/**
	 * Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
	 */
	@JsonProperty(required = false)
	Integer limit

	@Override
	@JsonIgnore
	String getPathMethod() {
		'getUserProfilePhotos'
	}
}
