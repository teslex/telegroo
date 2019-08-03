package micronaut.example.bot;

import io.micronaut.context.annotation.Factory;
import micronaut.example.config.TelegrooConfig;

import javax.inject.Singleton;

@Factory
public class TelegrooFactory {

	private final TelegrooConfig telegrooConfig;

	public TelegrooFactory(TelegrooConfig telegrooConfig) {
		this.telegrooConfig = telegrooConfig;
	}

	@Singleton
	MicronautTelegroo telegroo() {
		return new MicronautTelegroo(telegrooConfig.getToken());
	}
}
