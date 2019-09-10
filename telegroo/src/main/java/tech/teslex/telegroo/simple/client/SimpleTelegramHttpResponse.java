package tech.teslex.telegroo.simple.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import tech.teslex.telegroo.api.client.TelegramHttpResponse;
import tech.teslex.telegroo.telegram.api.TelegramErrorException;
import tech.teslex.telegroo.telegram.api.TelegramResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class SimpleTelegramHttpResponse implements TelegramHttpResponse<HttpResponse> {

	private final HttpResponse response;
	private final ObjectMapper objectMapper;

	public SimpleTelegramHttpResponse(HttpResponse response, ObjectMapper objectMapper) {
		this.response = response;
		this.objectMapper = objectMapper;
	}

	@Override
	public HttpResponse getHttpResponse() {
		return response;
	}

	@Override
	public InputStream getRawBody() {
		try {
			return response.getEntity().getContent();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new InputStream() {
			@Override
			public int read() {
				return 0;
			}
		};
	}

	@Override
	public <R> TelegramResult<R> asTelegramResult(JavaType type) {
		TelegramResult<R> result;

		Throwable throwable = null;

		try {
			log.debug(getRawBodyAsString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			result = objectMapper.readValue(getRawBody(), objectMapper.getTypeFactory().constructParametricType(TelegramResult.class, type));
		} catch (Exception e) {
			e.printStackTrace();
			result = new TelegramResult<>();
			result.setOk(false);
			result.setDescription(e.getMessage());
			throwable = e;
		}

		if (result.isOk())
			return result;
		else if (throwable != null)
			throw new TelegramErrorException(result, throwable);
		else
			throw new TelegramErrorException(result);
	}
}
