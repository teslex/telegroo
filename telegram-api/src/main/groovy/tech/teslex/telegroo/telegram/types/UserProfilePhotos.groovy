package tech.teslex.telegroo.telegram.types

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class UserProfilePhotos {

	Integer total_count

	List<PhotoSize> photos
}
