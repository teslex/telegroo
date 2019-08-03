package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.LeaveChat;

import java.util.Map;
import java.util.function.Consumer;

public interface LeaveChatMethod<R> {

	R leaveChat(Map data);

	R leaveChat(LeaveChat data);

	R leaveChat(Consumer<LeaveChat.LeaveChatBuilder> data);
}
