package tech.teslex.telegroo.telegram.api;

public class TelegramErrorException extends RuntimeException {

	private final TelegramResult<?> telegramResult;

	public <T> TelegramErrorException(TelegramResult<T> telegramResult) {
		super(telegramResult.getDescription());
		this.telegramResult = telegramResult;
	}

	public <T> TelegramErrorException(TelegramResult<T> telegramResult, Throwable cause) {
		super(telegramResult.getDescription(), cause);
		this.telegramResult = telegramResult;
	}

	public TelegramResult<?> getTelegramResult() {
		return telegramResult;
	}
}
