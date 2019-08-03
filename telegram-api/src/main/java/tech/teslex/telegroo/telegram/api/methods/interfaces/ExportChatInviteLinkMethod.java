package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.ExportChatInviteLink;

import java.util.Map;
import java.util.function.Consumer;

public interface ExportChatInviteLinkMethod<R> {

	R exportChatInviteLink(Map data);

	R exportChatInviteLink(ExportChatInviteLink data);

	R exportChatInviteLink(Consumer<ExportChatInviteLink.ExportChatInviteLinkBuilder> data);
}
