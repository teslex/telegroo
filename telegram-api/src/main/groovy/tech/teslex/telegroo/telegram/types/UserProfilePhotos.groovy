package tech.teslex.telegroo.telegram.types


import com.fasterxml.jackson.annotation.JsonProperty
import tech.teslex.telegroo.telegram.TypeAnnotations

@TypeAnnotations
class UserProfilePhotos {

	@JsonProperty(value = 'total_count')
	Integer totalCount

	List<PhotoSize> photos
}
