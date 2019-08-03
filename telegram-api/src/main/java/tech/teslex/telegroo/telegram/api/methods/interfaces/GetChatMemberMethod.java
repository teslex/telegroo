package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface GetChatMemberMethod<R> {

	R getChatMember(Map data);

	R getChatMember(GetChatMember data);

	R getChatMember(Consumer<GetChatMember.GetChatMemberBuilder> data);
}
