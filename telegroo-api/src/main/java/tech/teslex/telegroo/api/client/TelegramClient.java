/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * © 2019 TesLex
 */

package tech.teslex.telegroo.api.client;

import com.fasterxml.jackson.databind.JavaType;
import tech.teslex.telegroo.api.jackson.JacksonObjectMapper;
import tech.teslex.telegroo.telegram.api.TelegramErrorException;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithMedia;

import java.util.Map;

/**
 * TelegramClient
 */
public interface TelegramClient {

	TelegramHttpResponse<?> go(String method, Map<?, ?> parameters);

	TelegramHttpResponse<?> go(MethodObject methodObject);

	TelegramHttpResponse<?> go(MethodObjectWithFile methodObjectWithFile);

	TelegramHttpResponse<?> go(MethodObjectWithMedia methodObjectWithMedia);

	Map<Object, Object> getDefaultParams();

	void addDefaultParam(Object key, Object value);

	void addDefaultParams(Map<Object, Object> params);

	void removeDefaultParam(Object key);

	void clearDefaultParams();

	default <T> TelegramResult<T> handleTelegramResponse(TelegramHttpResponse<?> response, JavaType type) {
		TelegramResult<T> result;

		Throwable throwable = null;

		try {
			result = JacksonObjectMapper.getObjectMapper().readValue(response.getRawBody(), type);
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
