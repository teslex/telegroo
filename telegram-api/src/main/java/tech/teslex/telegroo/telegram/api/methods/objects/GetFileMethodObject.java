package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getFile
 * Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile again.
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetFileMethodObject implements MethodObject {

	/**
	 * File identifier to get info about
	 */
	@JsonProperty(value = "file_id", required = true)
	private String fileId;

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getFile";
	}
}
