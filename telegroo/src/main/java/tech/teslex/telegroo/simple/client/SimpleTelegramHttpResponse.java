package tech.teslex.telegroo.simple.client;

import org.apache.http.client.fluent.Response;
import tech.teslex.telegroo.api.client.TelegramHttpResponse;

import java.io.IOException;

public class SimpleTelegramHttpResponse implements TelegramHttpResponse<Response> {

	private Response response;

	public SimpleTelegramHttpResponse(Response response) {
		this.response = response;
	}

	@Override
	public Response getHttpResponse() {
		return response;
	}

	@Override
	public String getRawBody() {
		try {
			return response.returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
