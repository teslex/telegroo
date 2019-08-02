package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {
	/**
	 * Longitude as defined by sender
	 */
	private Float longitude;
	/**
	 * Latitude as defined by sender
	 */
	private Float latitude;
}
