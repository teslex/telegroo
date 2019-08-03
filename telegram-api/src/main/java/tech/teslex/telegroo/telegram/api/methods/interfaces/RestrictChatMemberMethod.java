package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.RestrictChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface RestrictChatMemberMethod<R> {

	R restrictChatMember(Map data);

	R restrictChatMember(RestrictChatMember data);

	R restrictChatMember(Consumer<RestrictChatMember.RestrictChatMemberBuilder> data);
}
