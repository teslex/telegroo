package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getUserProfilePhotos
 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserProfilePhotosMethodObject implements MethodObject {
	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(value = "user_id", required = true)
	private Integer userId;
	/**
	 * Sequential number of the first photo to be returned. By default, all photos are returned.
	 */
	@JsonProperty(required = false)
	private Integer offset;
	/**
	 * Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
	 */
	@JsonProperty(required = false)
	private Integer limit;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getUserProfilePhotos";
	}
}
