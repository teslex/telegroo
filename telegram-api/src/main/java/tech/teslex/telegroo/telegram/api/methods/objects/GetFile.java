package tech.teslex.telegroo.telegram.api.methods.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;

/**
 * getInputFile
 * Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getInputFile again.
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetFile implements MethodObject {
	/**
	 * File identifier to get info about
	 */
	@JsonProperty(value = "file_id", required = true)
	private String fileId;

	public static GetFile create() {
		return new GetFile();
	}

	@Override
	@JsonIgnore
	public String getPathMethod() {
		return "getInputFile";
	}

	public GetFile fileId(String fileId) {
		this.fileId = fileId;
		return this;
	}
}
