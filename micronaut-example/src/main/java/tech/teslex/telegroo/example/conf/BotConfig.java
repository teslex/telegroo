package tech.teslex.telegroo.example.conf;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ConfigurationProperties("bot")
public class BotConfig {

	@NotBlank
	private String token;

	@NotBlank
	private String webhookUrl;
}
