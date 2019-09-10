package tech.teslex.telegroo.api.methods.defaults;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces.ExportChatInviteLinkMethod;
import tech.teslex.telegroo.telegram.api.methods.objects.ExportChatInviteLink;

import java.util.Map;
import java.util.function.Consumer;

public interface DefaultExportChatInviteLinkMethod extends ExportChatInviteLinkMethod<TelegramResult<String>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<String> exportChatInviteLink(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<String> exportChatInviteLink(Consumer<ExportChatInviteLink> data) {
		ExportChatInviteLink method = ExportChatInviteLink.create();
		data.accept(method);

		return exportChatInviteLink(method);
	}

	@Override
	default TelegramResult<String> exportChatInviteLink(ExportChatInviteLink data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(String.class);

		return getContext()
				.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
