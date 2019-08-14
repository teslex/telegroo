package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetChatMembersCount;

import java.util.Map;
import java.util.function.Consumer;

public interface GetChatMembersCountMethod<R> {

	R getChatMembersCount(Map data);

	R getChatMembersCount(GetChatMembersCount data);

	R getChatMembersCount(Consumer<GetChatMembersCount> data);
}
