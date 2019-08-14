package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.UnbanChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface UnbanChatMemberMethod<R> {

	R unbanChatMember(Map data);

	R unbanChatMember(UnbanChatMember data);

	R unbanChatMember(Consumer<UnbanChatMember> data);
}
