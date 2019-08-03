package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.PromoteChatMember;

import java.util.Map;
import java.util.function.Consumer;

public interface PromoteChatMemberMethod<R> {

	R promoteChatMember(Map data);

	R promoteChatMember(PromoteChatMember data);

	R promoteChatMember(Consumer<PromoteChatMember.PromoteChatMemberBuilder> data);
}
