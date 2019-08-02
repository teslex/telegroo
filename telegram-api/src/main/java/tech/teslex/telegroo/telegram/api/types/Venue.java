package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Venue {
	/**
	 * Venue location
	 */
	private Location location;
	/**
	 * Name of the venue
	 */
	private String title;
	/**
	 * Address of the venue
	 */
	private String address;
	/**
	 * Optional. Foursquare identifier of the venue
	 */
	@JsonProperty(value = "foursquare_id", required = false)
	private String foursquareId;
	/**
	 * Optional. Foursquare value of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty(value = "foursquare_type", required = false)
	private String foursquareType;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFoursquareId() {
		return foursquareId;
	}

	public void setFoursquareId(String foursquareId) {
		this.foursquareId = foursquareId;
	}

	public String getFoursquareType() {
		return foursquareType;
	}

	public void setFoursquareType(String foursquareType) {
		this.foursquareType = foursquareType;
	}
}
