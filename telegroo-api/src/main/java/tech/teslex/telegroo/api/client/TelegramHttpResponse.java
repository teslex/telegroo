package tech.teslex.telegroo.api.client;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.telegram.api.TelegramResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public interface TelegramHttpResponse<T> {

	T getHttpResponse();

	InputStream getRawBody();

	// TODO: should be rewritten immediately!!!
	default String getRawBodyAsString() throws IOException {
		final int bufferSize = 1024;
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(getRawBody(), StandardCharsets.UTF_8);
		while (true) {
			int rsz = in.read(buffer, 0, buffer.length);
			if (rsz < 0)
				break;
			out.append(buffer, 0, rsz);
		}
		return out.toString();
	}

	<R> TelegramResult<R> asTelegramResult(JavaType type);
}