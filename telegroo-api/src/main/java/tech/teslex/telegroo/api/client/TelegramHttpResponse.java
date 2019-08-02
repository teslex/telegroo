package tech.teslex.telegroo.api.client;

public interface TelegramHttpResponse<T> {

	T getHttpResponse();

	String getRawBody();
}