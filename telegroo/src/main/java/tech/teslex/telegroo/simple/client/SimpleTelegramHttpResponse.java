package tech.teslex.telegroo.simple.client;

import org.apache.http.HttpResponse;
import tech.teslex.telegroo.api.client.TelegramHttpResponse;

import java.io.IOException;

public class SimpleTelegramHttpResponse implements TelegramHttpResponse<HttpResponse> {

	private HttpResponse response;

	public SimpleTelegramHttpResponse(HttpResponse response) {
		this.response = response;
	}

	@Override
	public HttpResponse getHttpResponse() {
		return response;
	}

	@Override
	public String getRawBody() {
		try {
			return response.getEntity().getContent().toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
