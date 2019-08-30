package tech.teslex.telegroo.api.client;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.telegram.api.TelegramResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface TelegramHttpResponse<T> {

	T getHttpResponse();

	InputStream getRawBody();

	default String getRawBodyAsString() throws IOException {
		StringBuilder sb = new StringBuilder();

		try (var br = new BufferedReader(new InputStreamReader(getRawBody()))) {
			String read;

			while ((read = br.readLine()) != null) {
				sb.append(read);
			}
		}

		return sb.toString();
	}

	<R> TelegramResult<R> asTelegramResult(JavaType type);
}