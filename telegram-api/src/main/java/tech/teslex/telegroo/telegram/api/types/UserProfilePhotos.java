package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfilePhotos {
	@JsonProperty(value = "total_count")
	private Integer totalCount;
	private List<PhotoSize> photos;
}
