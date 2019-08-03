package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.KickChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface KickChatMemberMethod<R> {

	R kickChatMember(Map data);

	R kickChatMember(KickChatMember data);

	R kickChatMember(Consumer<KickChatMember.KickChatMemberBuilder> data);
}
