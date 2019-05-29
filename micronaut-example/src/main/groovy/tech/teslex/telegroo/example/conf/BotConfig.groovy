package tech.teslex.telegroo.example.conf

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties

import javax.validation.constraints.NotBlank

@CompileStatic
@ConfigurationProperties('bot')
class BotConfig {

	@NotBlank
	String token

	@NotBlank
	String webhookUrl
}
