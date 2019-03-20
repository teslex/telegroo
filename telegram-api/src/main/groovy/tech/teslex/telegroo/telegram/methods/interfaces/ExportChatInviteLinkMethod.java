package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.ExportChatInviteLinkMethodObject;

import java.util.Map;

public interface ExportChatInviteLinkMethod<R> {

	R exportChatInviteLink(Map data);

	@NamedVariant
	R exportChatInviteLink(@NamedDelegate ExportChatInviteLinkMethodObject data);

	R exportChatInviteLink(@DelegatesTo(ExportChatInviteLinkMethodObject.class) Closure closure);
}
