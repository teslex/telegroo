package tech.teslex.telegroo.telegram.api.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.api.TypeAnnotations

@TypeAnnotations
class UserProfilePhotos {

	@JsonProperty(value = 'total_count')
	Integer totalCount

	List<PhotoSize> photos
}
