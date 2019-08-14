package tech.teslex.telegroo.simple.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.client.TelegramHttpResponse;
import tech.teslex.telegroo.api.jackson.DefaultJacksonObjectMapper;
import tech.teslex.telegroo.telegram.api.methods.MethodObject;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.api.methods.MethodObjectWithMedia;
import tech.teslex.telegroo.telegram.api.types.input.InputMedia;
import tech.teslex.telegroo.telegram.attach.FileInputFile;
import tech.teslex.telegroo.telegram.attach.IdInputFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleTelegramClient implements TelegramClient {

	private static final String url = "api.telegram.org";
	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;
	private final String token;

	public SimpleTelegramClient(String token) {
		this.token = token;
		this.objectMapper = DefaultJacksonObjectMapper.getObjectMapper();
		this.httpClient = HttpClientBuilder.create().build();
	}

	public SimpleTelegramClient(String token, ObjectMapper objectMapper) {
		this.token = token;
		this.objectMapper = objectMapper;
		this.httpClient = HttpClientBuilder.create().build();
	}

	public SimpleTelegramClient(String token, HttpClient httpClient) {
		this.token = token;
		this.httpClient = httpClient;
		this.objectMapper = DefaultJacksonObjectMapper.getObjectMapper();
	}

	public SimpleTelegramClient(String token, ObjectMapper objectMapper, HttpClient httpClient) {
		this.token = token;
		this.httpClient = httpClient;
		this.objectMapper = objectMapper;
	}

	@Override
	public TelegramHttpResponse<HttpResponse> call(String method, Map parameters) {
		try {
			return new SimpleTelegramHttpResponse(httpClient.execute(createRequest(method, parameters)), objectMapper);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new EmptyTelegramHttpResponse();
	}

	@Override
	public TelegramHttpResponse<HttpResponse> call(MethodObject data) {
		try {
			return new SimpleTelegramHttpResponse(httpClient.execute(createRequest(data)), objectMapper);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new EmptyTelegramHttpResponse();
	}

	@Override
	public TelegramHttpResponse<HttpResponse> callWithFile(MethodObjectWithFile data) {
		try {
			return new SimpleTelegramHttpResponse(httpClient.execute(createRequest(data)), objectMapper);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new EmptyTelegramHttpResponse();
	}

	@Override
	public TelegramHttpResponse<HttpResponse> callWithMedia(MethodObjectWithMedia data) {
		try {
			return new SimpleTelegramHttpResponse(httpClient.execute(createRequest(data)), objectMapper);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new EmptyTelegramHttpResponse();
	}

	private HttpUriRequest createRequest(String method, Map parameters) throws JsonProcessingException, UnsupportedEncodingException {
		String bodyString = objectMapper.writeValueAsString(parameters);

		HttpPost httpPost = new HttpPost(buildUrl(method));
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(bodyString));

		return httpPost;
	}

	private HttpUriRequest createRequest(MethodObject data) throws UnsupportedEncodingException, JsonProcessingException {
		String bodyString = objectMapper.writeValueAsString(data);

		HttpPost httpPost = new HttpPost(buildUrl(data.getPathMethod()));
		httpPost.setHeader("Content-Type", "application/json");

		HttpEntity httpEntity = new StringEntity(bodyString);

		httpPost.setEntity(httpEntity);

		return httpPost;
	}

	private HttpUriRequest createRequest(MethodObjectWithFile data) throws JsonProcessingException, UnsupportedEncodingException {
		JavaType mapType = objectMapper
				.getTypeFactory()
				.constructMapType(HashMap.class, String.class, Object.class);

		Map<String, Object> bodyMap = objectMapper.convertValue(data, mapType);

		HttpPost httpPost = new HttpPost(buildUrl(data.getPathMethod()));

		MultipartEntityBuilder httpEntityBuilder = MultipartEntityBuilder.create();

		if (data.getInputFile() instanceof FileInputFile) {
			for (Map.Entry<String, Object> entry : bodyMap.entrySet()) {
				httpEntityBuilder.addTextBody(entry.getKey(), objectMapper.writeValueAsString(entry.getValue()));
			}

			httpEntityBuilder
					.addBinaryBody(data.getInputFile().getMediaType().getValue(), ((FileInputFile) data.getInputFile()).getFile(), ContentType.MULTIPART_FORM_DATA, data.getInputFile().getMediaType().getValue());

			httpPost.setEntity(httpEntityBuilder.build());
			return httpPost;
		} else {
			if (data.getInputFile() instanceof IdInputFile) {
				Map<String, String> idMap = new HashMap<>();
				idMap.put("file_id", ((IdInputFile) data.getInputFile()).getFile());
				bodyMap.put("photo", idMap);
			} else {
				bodyMap.put("photo", data.getInputFile().getFile());
			}

			return createRequest(data.getPathMethod(), bodyMap);
		}
	}

	private HttpUriRequest createRequest(MethodObjectWithMedia data) throws JsonProcessingException {
		JavaType mapType = objectMapper
				.getTypeFactory()
				.constructMapType(HashMap.class, String.class, Object.class);

		Map<String, Object> bodyMap = objectMapper.convertValue(data, mapType);

		List<Map<String, Object>> mediaList = new ArrayList<>();
		for (InputMedia inputMedia : data.getMedia()) {
			Map<String, Object> media = objectMapper.convertValue(inputMedia, mapType);

			if (inputMedia.getMedia() instanceof FileInputFile) {
				media.put("media", "attach://" + ((FileInputFile) inputMedia.getMedia()).getFile().getName());
			} else if (inputMedia.getMedia() instanceof IdInputFile) {
				Map<String, String> idMap = new HashMap<>();
				idMap.put("file_id", ((IdInputFile) inputMedia.getMedia()).getFile());
				media.put("media", idMap);
			} else {
				media.put("media", inputMedia.getMedia().getFile());
			}

			mediaList.add(media);
		}

		bodyMap.put("media", mediaList);

		HttpPost httpPost = new HttpPost(buildUrl(data.getPathMethod()));

		MultipartEntityBuilder httpEntityBuilder = MultipartEntityBuilder.create();

		for (Map.Entry<String, Object> entry : bodyMap.entrySet()) {
			httpEntityBuilder.addTextBody(entry.getKey(), objectMapper.writeValueAsString(entry.getValue()));
		}

		data.getMedia()
				.stream()
				.filter(inputMedia -> inputMedia.getMedia() instanceof FileInputFile)
				.forEach(inputMedia -> httpEntityBuilder
						.addBinaryBody(inputMedia.getMedia().getMediaType().getValue(), ((FileInputFile) inputMedia.getMedia()).getFile(), ContentType.MULTIPART_FORM_DATA, inputMedia.getMedia().getMediaType().getValue()));

		httpPost.setEntity(httpEntityBuilder.build());

		return httpPost;
	}

	private String buildUrl(String method) {
		return "https://" + url + "/bot" + token + "/" + method;
	}
}
