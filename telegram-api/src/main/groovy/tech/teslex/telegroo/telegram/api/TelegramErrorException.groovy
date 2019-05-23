package tech.teslex.telegroo.telegram.api

import groovy.transform.CompileStatic

@CompileStatic
class TelegramErrorException extends RuntimeException {

	TelegramResult<Object> telegramResult

	TelegramErrorException(TelegramResult<Object> telegramResult) {
		super(telegramResult.description)
		this.telegramResult = telegramResult
	}
}
