package tech.teslex.telegroo.simple.client;

import com.fasterxml.jackson.databind.JavaType;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import tech.teslex.telegroo.api.client.TelegramHttpResponse;
import tech.teslex.telegroo.telegram.api.TelegramResult;

import java.io.InputStream;

class EmptyTelegramHttpResponse implements TelegramHttpResponse<HttpResponse> {

	private final HttpResponse httpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("http", 0, 0), 200, "empty response"));

	EmptyTelegramHttpResponse() {
	}

	@Override
	public HttpResponse getHttpResponse() {
		return httpResponse;
	}

	@Override
	public InputStream getRawBody() {
		return new InputStream() {
			@Override
			public int read() {
				return 0;
			}
		};
	}

	@Override
	public <R> TelegramResult<R> asTelegramResult(JavaType type) {
		final var result = new TelegramResult<R>();
		result.setOk(false);
		return result;
	}
}
